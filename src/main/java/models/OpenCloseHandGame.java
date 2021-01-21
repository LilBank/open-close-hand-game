package main.java.models;

import java.util.Scanner;

public class OpenCloseHandGame extends Game {
    private final String PREDICTOR_INPUT_REGEX = "([CO]|[CO]|[0-4]{0,1}){3,3}";
    private final String PLAYER_INPUT_REGEX = "([CO]|[CO]){2,2}";
    private final String PREDICTOR_INPUT_WARNING = "Please input in this format (C/O)(C/O)(0-4). Ex. CC0 OC1 OO4";
    private final String PLAYER_INPUT_WARNING = "Please input only within these choices: CC, OO, CO, OC";
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
        Result gameResult = null;
        Bot bot = new Bot("AI", GamerRole.PLAYER, new PlayerBehavior());

        System.out.printf("Welcome to the %s!%n", super.getName());
        
        while (true) {
            if (player.getRole() == GamerRole.PREDICTOR) {
                System.out.printf("%s are the %s, what's your input?%n", player.getName(), player.getRole());

                String playerInput = bot.getRandomAction();
                String predictorInput = this.validateInput(PREDICTOR_INPUT_REGEX, PREDICTOR_INPUT_WARNING);

                System.out.printf("AI: %s%n", playerInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));

                // Show results
                System.out.println(gameResult.getMessage());
            }
            if (player.getRole() == GamerRole.PLAYER) {
                System.out.printf("AI is the %s, what's your input?%n", bot.getName(), bot.getRole());

                String playerInput = this.validateInput(PLAYER_INPUT_REGEX, PLAYER_INPUT_WARNING);
                String predictorInput = bot.getRandomAction();

                System.out.printf("AI: %s%n", playerInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));

                // Show results
                System.out.println(gameResult.getMessage());
            }
            if (gameResult.getStatus()) {
                // TODO: Exit game with "N" input
                // Close Scanner
            }

            player.setRole(GamerRole.PLAYER);
            bot.setRole(GamerRole.PREDICTOR);
            bot.setBehavior(new PredictorBehavior());
        }
    }
    
    public String validateInput(String regex, String warning) {
        while (!scanner.hasNext(regex)) {
            System.out.println(warning);
            scanner.next();
        }

        return scanner.next();
    }
}
