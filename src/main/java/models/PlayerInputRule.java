package main.java.models;

import main.java.models.interfaces.Rule;

public class PlayerInputRule implements Rule {
    private final String PLAYER_INPUT_REGEX = "([CO]){2}";
    private final String PLAYER_INPUT_WARNING = "Please input only within these choices: CC, OO, CO, OC";

    @Override
    public Result validate(String input) {
        return input.matches(PLAYER_INPUT_REGEX) ? new Result(true, input) : new Result(false, PLAYER_INPUT_WARNING);
    }
}
