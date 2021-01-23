package main.java.models.abstracts;

import main.java.models.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private String name;
    private List<Rule> rules;

    protected Game(String name) {
        this.name = name;
        this.rules = new ArrayList<>();
    }

    public abstract void start(Player player);

    protected Rule getRule(String ruleName) {
        return this.rules.stream()
                         .filter(rule -> rule.getName().equals(ruleName))
                         .findFirst()
                         .get();
    }

    protected void addRule(Rule rule) {
        this.rules.add(rule);
    }

    protected String getName() {
        return this.name;
    }
}
