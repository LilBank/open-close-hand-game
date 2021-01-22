package test.java;

import main.java.models.PlayerBehavior;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestPlayerBehavior {
    private PlayerBehavior playerBehavior;

    @Before
    public void setUp() {
        playerBehavior = new PlayerBehavior();
    }

    @Test
    public void testGetAllPredictions() {
        List<String> expected = Arrays.asList("CC", "CO", "OO");
        List<String> actual = playerBehavior.relatedActions();

        assertTrue(expected.size() == actual.size());
        assertTrue(expected.containsAll(actual));
    }
}
