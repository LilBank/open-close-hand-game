package test.java;

import main.java.models.PredictorBehavior;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestPredictorBehavior {

    private PredictorBehavior predictorBehavior;

    @Before
    public void setUp() {
        predictorBehavior = new PredictorBehavior();
    }

    @Test
    public void testGetAllPredictions() {
        List<String> expected = Arrays.asList("CC0", "CC1", "CC2", "CC3", "CC4", "CO0", "CO1", "CO2", "CO3", "CO4", "OO0", "OO1", "OO2", "OO3", "OO4");
        List<String> actual = predictorBehavior.relatedActions();

        assertTrue(expected.size() == actual.size());
        assertTrue(expected.containsAll(actual));
    }
}
