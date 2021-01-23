package main.java.models;

import main.java.models.abstracts.Rule;
import main.java.models.enums.GamerRole;

import java.util.Scanner;

public class Player {
    private String name;
    private GamerRole role;

    public Player(String name, GamerRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public GamerRole getRole() {
        return this.role;
    }

    public void setRole(GamerRole newRole) {
        this.role = newRole;
    }

    public String play(Rule rule) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Result result = rule.validate(scanner.next());

            if (result.getOutcome()) {
                return result.getMessage();
            } else {
                System.out.println(result.getMessage());
            }
        }
    }
}
