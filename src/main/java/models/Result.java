package main.java.models;

public class Result {
    private final boolean outcome;
    private final String message;

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
