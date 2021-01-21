package main.java.models;

import java.util.Scanner;

public class OpenCloseHandGame extends Game {
    public OpenCloseHandGame(String name) {
        super(name);
        this.setUp();
    }

    private void setUp() {
        // Rule handsRule = new OpenCloseHandRule();
        // Rule predictorInputLengthRule = new PredictorInputLengthRule();
        // Rule predictorInputRule = new PredictorInputRule();
        // super.addRule(handsRule);
        // super.addRule(predictorInputLengthRule);
        // super.addRule(predictorInputRule);
    }

    @Override
    public void play(Player... players) {
        Scanner scanner = new Scanner(System.in);
        Player predictor = players[0];
        Player normalPlayer = players[1];
        boolean winnerFound = false;

        System.out.printf("Welcome to the %s!%n", super.getName());
        
        while(!winnerFound) {
            System.out.printf("%s is the %s, what's your input?%n", predictor.getName(), predictor.getRole());

            // if(true) {
            //     winnerFound = false;
            // }
        }
    }

    // public String validateInput(String input) {
    //     return "";
    // }
}
