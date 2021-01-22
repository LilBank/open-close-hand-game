package main.java.models;

import java.util.Scanner;

import main.java.models.enums.GamerRole;
import main.java.models.interfaces.Rule;

public class OpenCloseHandGame extends Game {
    private Scanner scanner;

    public OpenCloseHandGame(String name) {
        super(name, new OpenCloseHandRule());
        this.setUp();
    }

    private void setUp() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void play(Player player) {
        Player winner = null;
        Result gameResult = null;
        Bot bot = new Bot("AI", GamerRole.PLAYER, new PlayerBehavior());

        System.out.printf("Welcome to the %s!%n", super.getName());
        
        while (true) {
            if (player.getRole() == GamerRole.PREDICTOR) {
                System.out.printf("%s are the %s, what's your input?%n", player.getName(), player.getRole().toString().toLowerCase());

                String predictorInput = this.validateInput(new PredictorInputRule());
                String playerInput = bot.getRandomAction();

                System.out.printf("%s: %s%n", bot.getName(), playerInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = player;
            }
            if (player.getRole() == GamerRole.PLAYER) {
                System.out.printf("%s is the %s, what's your input?%n", bot.getName(), bot.getRole().toString().toLowerCase());

                String playerInput = this.validateInput(new PlayerInputRule());
                String predictorInput = bot.getRandomAction();

                System.out.printf("%s: %s%n", bot.getName(), predictorInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = bot;
            }
            if (gameResult.getOutcome()) {
                System.out.printf("%s %s%n", winner.getName(), gameResult.getMessage());
                System.out.println("Do you want to play again?");
                
                String newGameInput = validateInput(new NewGameRule());

                if (newGameInput.toLowerCase().equals("n")) {
                    scanner.close();
                    System.out.println("Ok, bye!");
                    break;
                }
            } else {
                System.out.println(gameResult.getMessage());
            }
            
            this.switchPlayersState(player, bot);
        }
    }

    private String validateInput(Rule rule) {
        while (true) {
            Result result = rule.validate(scanner.next());

            if (result.getOutcome()) {
                return result.getMessage();
            } else {
                System.out.println(result.getMessage());
            }
        }
    }

    private void switchPlayersState(Player player, Bot bot) {
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
}
