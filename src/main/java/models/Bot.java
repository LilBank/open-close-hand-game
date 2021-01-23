package main.java.models;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import main.java.models.abstracts.Rule;
import main.java.models.enums.GamerRole;
import main.java.models.interfaces.Behavior;

public class Bot extends Player {
    private Behavior behavior;
    private Random randomizer = new Random();

    public Bot(String name, GamerRole role, Behavior behavior) {
        super(name, role);
        this.behavior = behavior;
    }

    @Override
    public String play(Rule rule) {
        System.out.printf("%s is using his big brain...%n", this.getName());
        System.out.printf("%s: This gonna take me a while :P%n", this.getName());

        while (true) {
            List<String> actions = behavior.relatedActions();
            int inputLimit = randomizer.nextInt(actions.size()) + 1;
            StringBuilder botInput = new StringBuilder();

            for (int i = 0; i < inputLimit; i++) {
                botInput.append(actions.get(randomizer.nextInt(actions.size())));
            }

            Result result = rule.validate(botInput.toString());

            System.out.printf("%s's big brain input: %s%n", this.getName(), botInput);

            if (result.getOutcome()) {
                return result.getMessage();
            } else {
                System.out.println(result.getMessage());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setBehavior(Behavior newBehavior) {
        this.behavior = newBehavior;
    }
}
