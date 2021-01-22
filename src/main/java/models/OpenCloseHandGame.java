package main.java.models;

import main.java.models.enums.GamerRole;

public class OpenCloseHandGame extends Game {

    public OpenCloseHandGame(String name) {
        super(name, new OpenCloseHandRule());
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

                String predictorInput = player.play(new PredictorInputRule());
                String playerInput = bot.play(new PlayerInputRule());

                System.out.printf("%s: %s%n", bot.getName(), playerInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = player;
            }
            if (player.getRole() == GamerRole.PLAYER) {
                System.out.printf("%s is the %s, what's your input?%n", bot.getName(), bot.getRole().toString().toLowerCase());

                String playerInput = player.play(new PlayerInputRule());
                String predictorInput = bot.play(new PredictorInputRule());

                System.out.printf("%s: %s%n", bot.getName(), predictorInput);

                gameResult = super.getRule().validate(playerInput.concat(predictorInput));
                winner = bot;
            }
            if (gameResult.getOutcome()) {
                System.out.printf("%s %s%n", winner.getName(), gameResult.getMessage());
                System.out.println("Do you want to play again?");
                
                String newGameInput = player.play(new NewGameRule());

                if (newGameInput.equalsIgnoreCase("n")) {
                    System.out.println("Ok, bye!");
                    break;
                }
            } else {
                System.out.println(gameResult.getMessage());
            }
            
            this.switchPlayersState(player, bot);
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
