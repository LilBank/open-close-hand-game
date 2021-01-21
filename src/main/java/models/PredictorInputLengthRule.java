package main.java.models;

public class PredictorInputLengthRule implements Rule {
    
    private final String INPUT_WARNING = "Please input only 3 characters.";
    
    @Override
    public String validate(String input) {
        return input.length() == 0 || input.length() > 3 ? INPUT_WARNING : "";
    }
}
