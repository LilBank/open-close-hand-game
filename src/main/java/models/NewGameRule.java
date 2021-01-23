package main.java.models;

import main.java.models.abstracts.Rule;

public class NewGameRule extends Rule {
    private final String NEW_GAME_INPUT_REGEX = "([yYnN]){1}";
    private final String NEW_GAME_WARNING = "Please input only Y/N.";

    public NewGameRule(String name) {
        super(name);
    }

    @Override
    public Result validate(String input) {
        return input.matches(NEW_GAME_INPUT_REGEX) ? new Result(true, input) : new Result(false, NEW_GAME_WARNING);
    }   
}
