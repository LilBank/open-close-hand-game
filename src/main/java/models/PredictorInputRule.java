package main.java.models;

public class PredictorInputRule implements Rule {

    private final String HAND_REGEX = "[CO]";
    private final String GUESS_REGEX = "[0-4]";
    private final String INPUT_WARNING = "Please input only letters O and C with number within range of 0-4";
    
    @Override
    public String validate(String input) {
        String firstHand = input.substring(0,1);
        String secondHand = input.substring(1,2);
        String guess = input.substring(2);

        boolean isHand = firstHand.matches(HAND_REGEX) && secondHand.matches(HAND_REGEX);
        boolean isGuess = guess.matches(GUESS_REGEX);

        boolean isValidInput = isHand && isGuess;

        return !isValidInput ? INPUT_WARNING : "";
    }
}
