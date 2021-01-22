package main.java.models;

import main.java.models.interfaces.Rule;

public class OpenCloseHandRule implements Rule {

    @Override
    public Result validate(String input) {
        int guess = Integer.parseInt(input.substring(4));
        int openingHands = input.substring(0, 4).replace("C", "").length();

        return openingHands == guess ? new Result(true, "WIN!!") : new Result(false, "No Winner.");
    }
}
