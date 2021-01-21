package main.java.models;

public class Result {
    private boolean status;
    private String message;

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
