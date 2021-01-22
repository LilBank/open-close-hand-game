package main.java.models;

import main.java.models.interfaces.Rule;

public abstract class Game {
    private String name;
    private Rule rule;

    protected Game(String name, Rule rule) {
        this.name = name;
        this.rule = rule;
    }

    public abstract void start(Player player);

    protected Rule getRule() {
        return this.rule;
    }

    protected String getName() {
        return this.name;
    }
}
