package main.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.models.interfaces.Behavior;

public class PlayerBehavior implements Behavior {

    @Override
    public List<String> relatedActions() {
        Random random = new Random();
        List<String> actions = new ArrayList<>();

        String closeHands = random.nextBoolean() ? "C" : "c";
        String openHands = random.nextBoolean() ? "O" : "o";

        actions.add(closeHands);
        actions.add(openHands);

        return actions;
    }
}
