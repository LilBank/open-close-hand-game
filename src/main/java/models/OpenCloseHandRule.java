package main.java.models;

public class OpenCloseHandRule implements Rule {

    @Override
    public String validate(String input) {
        int guess = Integer.parseInt(input.substring(4));
        int openingHands = input.substring(0, 4).replace("C", "").length();

        return openingHands == guess ? "WIN!!" : "No Winner.";
    }
}
