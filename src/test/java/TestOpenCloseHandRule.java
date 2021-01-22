package test.java;

import main.java.models.OpenCloseHandRule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOpenCloseHandRule {
    @Test
    public void testValidInput() {
        OpenCloseHandRule rule = new OpenCloseHandRule();

        String sampleValidInput = "CCOC1";

        assertTrue(rule.validate(sampleValidInput).getOutcome());
    }

    @Test
    public void testValidInputs() {
        OpenCloseHandRule rule = new OpenCloseHandRule();

        String sampleValidInput1 = "CCCC0";
        String sampleValidInput2 = "CCOO2";
        String sampleValidInput3 = "OCOO3";
        String sampleValidInput4 = "COOC2";
        String sampleValidInput5 = "OOCO3";
        String sampleValidInput6 = "OOOO4";
        String sampleValidInput7 = "OCCC1";

        assertTrue(rule.validate(sampleValidInput1).getOutcome());
        assertTrue(rule.validate(sampleValidInput2).getOutcome());
        assertTrue(rule.validate(sampleValidInput3).getOutcome());
        assertTrue(rule.validate(sampleValidInput4).getOutcome());
        assertTrue(rule.validate(sampleValidInput5).getOutcome());
        assertTrue(rule.validate(sampleValidInput6).getOutcome());
        assertTrue(rule.validate(sampleValidInput7).getOutcome());
    }

    @Test
    public void testInvalidInput() {
        OpenCloseHandRule rule = new OpenCloseHandRule();

        String sampleInvalidInput = "AACO1";

        assertFalse(rule.validate(sampleInvalidInput).getOutcome());
    }

    @Test
    public void testInvalidInputs() {
        OpenCloseHandRule rule = new OpenCloseHandRule();

        String sampleInvalidInput1 = "OOOO0";
        String sampleInvalidInput2 = "CCCC5";
        String sampleInvalidInput3 = "OOCC3";
        String sampleInvalidInput4 = "AAAA9";
        String sampleInvalidInput5 = "DOCK1";

        assertFalse(rule.validate(sampleInvalidInput1).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput2).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput3).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput4).getOutcome());
        assertFalse(rule.validate(sampleInvalidInput5).getOutcome());
    }
}
