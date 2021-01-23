package test.java;

import main.java.models.PredictorInputRule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPredictionInputRule {

    @Test
    public void testValidInput() {
        PredictorInputRule rule = new PredictorInputRule("Predictor's Input Rule");

        String sampleValidInput = "CC0";

        assertTrue(rule.validate(sampleValidInput).getOutcome());
    }

    @Test
    public void testValidInputs() {
        PredictorInputRule rule = new PredictorInputRule("Predictor's Input Rule");

        String sampleValidInput1 = "CC0";
        String sampleValidInput2 = "CO0";
        String sampleValidInput3 = "OO0";
        String sampleValidInput4 = "OC1";
        String sampleValidInput5 = "OC4";

        assertTrue(rule.validate(sampleValidInput1).getOutcome());
        assertTrue(rule.validate(sampleValidInput2).getOutcome());
        assertTrue(rule.validate(sampleValidInput3).getOutcome());
        assertTrue(rule.validate(sampleValidInput4).getOutcome());
        assertTrue(rule.validate(sampleValidInput5).getOutcome());
    }

    @Test
    public void testInvalidInput() {
        PredictorInputRule rule = new PredictorInputRule("Predictor's Input Rule");

        String sampleInvalidInput = "AA5";

        assertFalse(rule.validate(sampleInvalidInput).getOutcome());
    }

    @Test
    public void testInvalidInputs() {
        PredictorInputRule rule = new PredictorInputRule("Predictor's Input Rule");

        String sampleInvalidInput1 = "AA5";
        String sampleInvalidInput2 = "Wrong Input";
        String sampleInvalidInput3 = "...";
        String sampleInvalidInput4 = "";
        String sampleInvalidInput5 = "CCC";

        assertFalse(rule.validate(sampleInvalidInput1).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput2).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput3).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput4).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput5).getOutcome());
    }
}
