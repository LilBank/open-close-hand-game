package main.java.models;

import main.java.models.abstracts.Rule;

public class OpenCloseHandRule extends Rule {

    public OpenCloseHandRule(String name) {
        super(name);
    }

    @Override
    public Result validate(String input) {
        int guess = Integer.parseInt(input.substring(4));
        int openingHands = input.substring(0, 4).replace("C", "").length();

        return openingHands == guess ? new Result(true, "WIN!!") : new Result(false, "No Winner.");
    }
}
