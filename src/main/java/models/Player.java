package main.java.models;

import main.java.models.enums.GamerRole;

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
}
