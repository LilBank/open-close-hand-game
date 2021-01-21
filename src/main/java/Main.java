package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.models.*;

public class Main {
    public static void main(String[] args) {
        // OpenCloseHandRule firstRule = new OpenCloseHandRule();
        // String result = firstRule.validate("OOCC2");
        // System.out.println(result);

        // boolean isHand = "C".matches("[CO]");
        // boolean isGuess = "1".matches("[0-4]");
        // System.out.println(isHand);
        // System.out.println(isGuess);

        List<Rule> rules = new ArrayList<>();
        // rules.add(new OpenCloseHandRule());
        rules.add(new PredictorInputLengthRule());
        rules.add(new PredictorInputRule());
        
        List<String> results = rules.stream().map(rule -> rule.validate("OO4")).collect(Collectors.toList());
        results.forEach(result -> System.out.println(result));
        System.out.println(rules.size());
    }
}