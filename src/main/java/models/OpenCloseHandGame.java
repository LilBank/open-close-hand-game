package main.java.models;

import java.util.Scanner;

public class OpenCloseHandGame extends Game {
    private final String PREDICTOR_INPUT_REGEX = "([CO]|[CO]|[0-4]{1,1}){3,3}";
    private final String PLAYER_INPUT_REGEX = "([CO]|[CO]){2,2}";
    private final String NEW_GAME_INPUT_REGEX = "([yYnN]){1,1}";
    private final String PREDICTOR_INPUT_WARNING = "Please input in this format (C/O)(C/O)(0-4). Ex. CC0 OC1 OO4";
    private final String PLAYER_INPUT_WARNING = "Please input only within these choices: CC, OO, CO, OC";
    private final String NEW_GAME_WARNING = "Please input only Y/N.";
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

                String predictorInput = this.validateInput(PREDICTOR_INPUT_REGEX, PREDICTOR_INPUT_WARNING);
                String playerInput = bot.getRandomAction();

                System.out.printf("%s: %s%n", bot.getName(), playerInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = player;
            }
            if (player.getRole() == GamerRole.PLAYER) {
                System.out.printf("%s is the %s, what's your input?%n", bot.getName(), bot.getRole().toString().toLowerCase());

                String playerInput = this.validateInput(PLAYER_INPUT_REGEX, PLAYER_INPUT_WARNING);
                String predictorInput = bot.getRandomAction();

                System.out.printf("%s: %s%n", bot.getName(), predictorInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = bot;
            }
            if (gameResult.getStatus()) {
                System.out.printf("%s %s%n", winner.getName(), gameResult.getMessage());
                System.out.println("Do you want to play again?");
                
                String newGameInput = validateInput(NEW_GAME_INPUT_REGEX, NEW_GAME_WARNING);

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

    // private String earlyGame(Player player, Bot bot) {
    //     System.out.printf("%s are the %s, what's your input?%n", player.getName(), player.getRole().toString().toLowerCase());

    //     String predictorInput = this.validateInput(PREDICTOR_INPUT_REGEX, PREDICTOR_INPUT_WARNING);
    //     String playerInput = bot.getRandomAction();

    //     System.out.printf("%s: %s%n", bot.getName(), playerInput);
    // }

    private String validateInput(String regex, String warning) {
        while (!scanner.hasNext(regex)) {
            System.out.println(warning);
            scanner.next();
        }

        return scanner.next();
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
