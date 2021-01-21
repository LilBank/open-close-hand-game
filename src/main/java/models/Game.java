package main.java.models;

public abstract class Game {
    private String name;
    private Rule rule;

    protected Game(String name, Rule rule) {
        this.name = name;
        this.rule = rule;
    }

    public abstract void play(Player player);

    protected void setRule(Rule newRule) {
        this.rule = newRule;
    }

    protected Rule getRule() {
        return this.rule;
    }

    protected String getName() {
        return this.name;
    }
}
