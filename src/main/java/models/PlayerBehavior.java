package main.java.models;

import java.util.Arrays;
import java.util.List;

import main.java.models.interfaces.Behavior;

public class PlayerBehavior implements Behavior {

    @Override
    public List<String> relatedActions() {
        String[] defaultAction = {"CC", "CO", "OO"};

        return Arrays.asList(defaultAction);
    }
}
