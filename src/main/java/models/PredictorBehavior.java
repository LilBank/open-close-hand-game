package main.java.models;

import java.util.ArrayList;
import java.util.List;

import main.java.models.interfaces.Behavior;

public class PredictorBehavior implements Behavior {

    @Override
    public List<String> relatedActions() {
        String[] defaultAction = {"CC", "CO", "OO"};
        List<String> actions = new ArrayList<>();

        for (int i = 0; i < defaultAction.length; i++) {
            for (int j = 0; j < 5; j++) {
                actions.add(String.format("%s%d", defaultAction[i], j));
            }
        }

        return actions;
    }
}
