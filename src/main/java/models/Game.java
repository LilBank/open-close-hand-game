package main.java.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private String name;
    // private List<Rule> rules;

    protected Game(String name) {
        this.name = name;
        // this.rules = new ArrayList<>();
    }

    public abstract void play(Player... players);

    // protected void addRule(Rule rule) {
    //     this.rules.add(rule);
    // }

    // protected void removeRule(Rule rule) {
    //     this.rules.remove(rule);
    // }

    protected String getName() {
        return this.name;
    }
}
