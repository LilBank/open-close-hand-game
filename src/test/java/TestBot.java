package test.java;

import main.java.models.Bot;
import main.java.models.PlayerBehavior;
import main.java.models.PredictorBehavior;
import main.java.models.enums.GamerRole;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBot {

    @Test
    public void testBotPrediction() {
        PredictorBehavior predictorBehavior = new PredictorBehavior();
        Bot bot = new Bot("AI", GamerRole.PREDICTOR, predictorBehavior);

        String expected = "([CO]|[CO]|[0-4]{1,1}){3,3}";
        String actual = bot.getRandomAction();

        assertTrue(actual.matches(expected));
    }

    @Test
    public void testBotPredictions() {
        PredictorBehavior predictorBehavior = new PredictorBehavior();
        Bot bot = new Bot("AI", GamerRole.PREDICTOR, predictorBehavior);

        String expected = "([CO]|[CO]|[0-4]{1,1}){3,3}";
        String actual1 = bot.getRandomAction();
        String actual2 = bot.getRandomAction();
        String actual3 = bot.getRandomAction();
        String actual4 = bot.getRandomAction();
        String actual5 = bot.getRandomAction();

        assertTrue(actual1.matches(expected));
        assertTrue(actual2.matches(expected));
        assertTrue(actual3.matches(expected));
        assertTrue(actual4.matches(expected));
        assertTrue(actual5.matches(expected));
    }

    @Test
    public void testBotPlayerAction() {
        PlayerBehavior playerBehavior = new PlayerBehavior();
        Bot bot = new Bot("AI", GamerRole.PLAYER, playerBehavior);

        String expected = "([CO]|[CO]){2,2}";
        String actual = bot.getRandomAction();

        assertTrue(actual.matches(expected));
    }

    @Test
    public void testBotPlayerActions() {
        PlayerBehavior playerBehavior = new PlayerBehavior();
        Bot bot = new Bot("AI", GamerRole.PLAYER, playerBehavior);

        String expected = "([CO]|[CO]){2,2}";
        String actual1 = bot.getRandomAction();
        String actual2 = bot.getRandomAction();
        String actual3 = bot.getRandomAction();
        String actual4 = bot.getRandomAction();
        String actual5 = bot.getRandomAction();

        assertTrue(actual1.matches(expected));
        assertTrue(actual2.matches(expected));
        assertTrue(actual3.matches(expected));
        assertTrue(actual4.matches(expected));
        assertTrue(actual5.matches(expected));
    }
}
