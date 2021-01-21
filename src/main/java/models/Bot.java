package main.java.models;

import java.util.List;
import java.util.Random;

public class Bot extends Player {
    private Behavior behavior;
    private Random randomizer = new Random();

    public Bot(String name, GamerRole role, Behavior behavior) {
        super(name, role);
        this.behavior = behavior;
    }

    public String getRandomAction() {
        List<String> behaviors = behavior.relatedActions();

        return behaviors.get(randomizer.nextInt(behaviors.size()));
    }

    public void setBehavior(Behavior newBehavior) {
        this.behavior = newBehavior;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }
}
