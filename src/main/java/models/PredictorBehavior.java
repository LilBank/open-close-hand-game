package main.java.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import main.java.models.interfaces.Behavior;

public class PredictorBehavior implements Behavior {

    @Override
    public List<String> relatedActions() {
        Random random = new Random();
        int randomGuess = random.nextInt(3) + 1;

        List<String> actions = new ArrayList<>(Arrays.asList("C", "O"));
        actions.add(String.valueOf(randomGuess));

        return actions;
    }
}
