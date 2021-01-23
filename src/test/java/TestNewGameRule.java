package test.java;

import main.java.models.NewGameRule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestNewGameRule {
    @Test
    public void testValidInput() {
        NewGameRule rule = new NewGameRule("New Game Input Rule");

        String sampleValidInput = "Y";

        assertTrue(rule.validate(sampleValidInput).getOutcome());
    }

    @Test
    public void testValidInputs() {
        NewGameRule rule = new NewGameRule("New Game Input Rule");

        String sampleValidInput1 = "Y";
        String sampleValidInput2 = "y";
        String sampleValidInput3 = "N";
        String sampleValidInput4 = "n";

        assertTrue(rule.validate(sampleValidInput1).getOutcome());
        assertTrue(rule.validate(sampleValidInput2).getOutcome());
        assertTrue(rule.validate(sampleValidInput3).getOutcome());
        assertTrue(rule.validate(sampleValidInput4).getOutcome());
    }

    @Test
    public void testInvalidInput() {
        NewGameRule rule = new NewGameRule("New Game Input Rule");

        String sampleInvalidInput = "O";

        assertFalse(rule.validate(sampleInvalidInput).getOutcome());
    }

    @Test
    public void testInvalidInputs() {
        NewGameRule rule = new NewGameRule("New Game Input Rule");

        String sampleInvalidInput1 = "Z";
        String sampleInvalidInput2 = "Wrong Input";
        String sampleInvalidInput3 = "...";
        String sampleInvalidInput4 = "";

        assertFalse(rule.validate(sampleInvalidInput1).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput2).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput3).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput4).getOutcome());
    }
}
