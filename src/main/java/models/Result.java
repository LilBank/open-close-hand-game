package main.java.models;

public class Result {
    private boolean outcome;
    private String message;

    public Result(boolean status, String message) {
        this.outcome = status;
        this.message = message;
    }

    public boolean getOutcome() {
        return this.outcome;
    }

    public String getMessage() {
        return this.message;
    }
}
