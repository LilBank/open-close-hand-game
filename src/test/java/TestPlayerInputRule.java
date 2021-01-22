package test.java;

import main.java.models.PlayerInputRule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPlayerInputRule {
    @Test
    public void testValidInput() {
        PlayerInputRule rule = new PlayerInputRule();

        String sampleValidInput = "CC";

        assertTrue(rule.validate(sampleValidInput).getOutcome());
    }

    @Test
    public void testValidInputs() {
        PlayerInputRule rule = new PlayerInputRule();

        String sampleValidInput1 = "CC";
        String sampleValidInput2 = "CO";
        String sampleValidInput3 = "OO";
        String sampleValidInput4 = "OC";

        assertTrue(rule.validate(sampleValidInput1).getOutcome());
        assertTrue(rule.validate(sampleValidInput2).getOutcome());
        assertTrue(rule.validate(sampleValidInput3).getOutcome());
        assertTrue(rule.validate(sampleValidInput4).getOutcome());
    }

    @Test
    public void testInvalidInput() {
        PlayerInputRule rule = new PlayerInputRule();

        String sampleInvalidInput = "AA5";

        assertFalse(rule.validate(sampleInvalidInput).getOutcome());
    }

    @Test
    public void testInvalidInputs() {
        PlayerInputRule rule = new PlayerInputRule();

        String sampleInvalidInput1 = "OG";
        String sampleInvalidInput2 = "Wrong Input";
        String sampleInvalidInput3 = "...";
        String sampleInvalidInput4 = "";

        assertFalse(rule.validate(sampleInvalidInput1).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput2).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput3).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput4).getOutcome());
    }
}
