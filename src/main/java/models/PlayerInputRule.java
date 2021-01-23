package main.java.models;

import main.java.models.abstracts.Rule;

public class PlayerInputRule extends Rule {
    private final String PLAYER_INPUT_REGEX = "([CO]){2}";
    private final String PLAYER_INPUT_WARNING = "Please input only within these choices: CC, OO, CO, OC";

    public PlayerInputRule(String name) {
        super(name);
    }

    @Override
    public Result validate(String input) {
        return input.matches(PLAYER_INPUT_REGEX) ? new Result(true, input) : new Result(false, PLAYER_INPUT_WARNING);
    }
}
