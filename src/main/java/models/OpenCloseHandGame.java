package main.java.models;

import main.java.models.abstracts.Game;
import main.java.models.abstracts.Rule;
import main.java.models.enums.GamerRole;

public class OpenCloseHandGame extends Game {
    private final String OPEN_CLOSE_HAND_RULE_NAME = "Open Close Hand Game Rule";
    private final String NEW_GAME_RULE_NAME = "New Game Input Rule";
    private final String PREDICTOR_INPUT_RULE_NAME = "Predictor's Input Rule";
    private final String PLAYER_INPUT_RULE_NAME = "Player's Input Rule";

    private String winner;
    private boolean isRunning = true;

    public OpenCloseHandGame(String name) {
        super(name);
        this.setUp();
    }

    private void setUp() {
        super.addRule(new PlayerInputRule(PLAYER_INPUT_RULE_NAME));
        super.addRule(new PredictorInputRule(PREDICTOR_INPUT_RULE_NAME));
        super.addRule(new NewGameRule(NEW_GAME_RULE_NAME));
        super.addRule(new OpenCloseHandRule(OPEN_CLOSE_HAND_RULE_NAME));
    }

    @Override
    public void start(Player player) {
        Bot bot = new Bot("AI", GamerRole.PLAYER, new PlayerBehavior());

        System.out.printf("Welcome to the %s!%n", super.getName());
        
        while (isRunning) {
            this.displayInputQuestion(player, bot);

            String playerInput = this.getInput(player);
            String botInput = this.getInput(bot);

            this.displayBotInput(bot, botInput);

            Result gameResult = this.getGameResult(player, bot, playerInput, botInput);

            this.displayGameResult(gameResult);

            isRunning = this.newGameInput(player);

            this.switchPlayersRole(player, bot);
        }
    }

    private void switchPlayersRole(Player player, Bot bot) {
        if (player.getRole() == GamerRole.PREDICTOR) {
            player.setRole(GamerRole.PLAYER);
            bot.setRole(GamerRole.PREDICTOR);
            bot.setBehavior(new PredictorBehavior());
        } else {
            player.setRole(GamerRole.PREDICTOR);
            bot.setRole(GamerRole.PLAYER);
            bot.setBehavior(new PlayerBehavior());
        }
    }

    private void displayInputQuestion(Player player, Bot bot) {
        if (player.getRole() == GamerRole.PREDICTOR) {
            System.out.printf("%s are the %s, what's your input?%n", player.getName(), player.getRole().toString().toLowerCase());
        } else {
            System.out.printf("%s is the %s, what's your input?%n", bot.getName(), bot.getRole().toString().toLowerCase());
        }
    }

    private String getInput(Player player) {
        String ruleName = player.getRole() == GamerRole.PREDICTOR ? PREDICTOR_INPUT_RULE_NAME : PLAYER_INPUT_RULE_NAME;

        return player.play(super.getRule(ruleName));
    }

    private void displayBotInput(Bot bot, String input) {
        System.out.printf("%s: %s%n", bot.getName(), input);
    }

    private Result getGameResult(Player player, Player bot, String playerInput, String botInput) {
        Rule rule = super.getRule(OPEN_CLOSE_HAND_RULE_NAME);
        Result result;

        if (player.getRole() == GamerRole.PREDICTOR) {
            result = rule.validate(botInput.concat(playerInput));
            winner = result.getOutcome() ? player.getName() : "";
        } else {
            result = rule.validate(playerInput.concat(botInput));
            winner = result.getOutcome() ? bot.getName() : "";
        }

        return result;
    }

    private void displayGameResult(Result result) {
        if (result.getOutcome()) {
            System.out.printf("%s %s%n", winner, result.getMessage());
        } else {
            System.out.println(result.getMessage());
        }
    }

    private boolean newGameInput(Player player) {
        System.out.println("Do you want to play again?");

        String newGameInput = player.play(super.getRule(NEW_GAME_RULE_NAME));

        if (newGameInput.equalsIgnoreCase("n")) {
            System.out.println("Ok, bye!");
            return false;
        } else {
            return true;
        }
    }
}
