package main.java.models;

public class Player {
    private String name;
    private String role;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String newRole) {
        this.role = newRole;
    }
}
