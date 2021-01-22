package main.java.models;

import main.java.models.interfaces.Rule;

public class NewGameRule implements Rule {
    private final String NEW_GAME_INPUT_REGEX = "([yYnN]){1,1}";
    private final String NEW_GAME_WARNING = "Please input only Y/N.";

    @Override
    public Result validate(String input) {
        return input.matches(NEW_GAME_INPUT_REGEX) ? new Result(true, input) : new Result(false, NEW_GAME_WARNING);
    }   
}
