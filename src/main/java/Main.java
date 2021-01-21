package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.models.*;

public class Main {
    public static void main(String[] args) {
        // OpenCloseHandRule firstRule = new OpenCloseHandRule();
        // String result = firstRule.validate("CCCC0");
        // System.out.println(result);

        // List<Rule> rules = new ArrayList<>();
        // rules.add(new PredictorInputLengthRule());
        // rules.add(new PredictorInputRule());
        
        // List<String> results = rules.stream().map(rule -> rule.validate("AA5A")).collect(Collectors.toList());
        // results.forEach(result -> System.out.println(result));

        // List<String> list = new ArrayList<>();
        // String[] botBehaviour = {"CC", "CO", "OO"};

        // for (int i = 0; i < botBehaviour.length; i++) {
        //     for (int j = 0; j < 5; j++) {
        //         list.add(String.format("%s%d",botBehaviour[i],j));
        //     }
        // }
        // list.forEach(element -> System.out.println(element));

        // Bot bot = new Bot("AI", GamerRole.PLAYER, new PredictorBehavior());
        // bot.getBehavior().relatedActions().forEach(ele -> System.out.println(ele));

        // Scanner sc = new Scanner(System.in);
        // String predictorInputRegex = "([CO]|[CO]){2,2}";
        // while(!sc.hasNext(predictorInputRegex)) {
        //     System.out.println("Wrong!");
        //     sc.next();
        // }
        // String predictorInput = sc.next();
        // System.out.println(predictorInput);
        // sc.close();
    }
}