package main.java.models.abstracts;

import main.java.models.Result;

public abstract class Rule {
    private final String name;

    protected Rule(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    abstract public Result validate(String input);
}
