package main.java;

import main.java.models.GamerRole;
import main.java.models.OpenCloseHandGame;
import main.java.models.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("You", GamerRole.PREDICTOR);
        OpenCloseHandGame openCloseHandGame = new OpenCloseHandGame("Open Close Hand Game");
        openCloseHandGame.play(player);
    }
}