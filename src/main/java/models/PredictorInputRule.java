package main.java.models;

import main.java.models.interfaces.Rule;

public class PredictorInputRule implements Rule {
    private final String PREDICTOR_INPUT_REGEX = "([CO]|[CO]|[0-4]{1,1}){3,3}";
    private final String PREDICTOR_INPUT_WARNING = "Please input in this format (C/O)(C/O)(0-4). Ex. CC0 OC1 OO4";

    @Override
    public Result validate(String input) {
        return input.matches(PREDICTOR_INPUT_REGEX) ? new Result(true, input) : new Result(false, PREDICTOR_INPUT_WARNING);
    }
}
