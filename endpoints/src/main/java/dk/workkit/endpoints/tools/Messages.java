package dk.workkit.endpoints.tools;

public enum Messages {
    UNAUTHORIZED("Unauthorized. Please login to access this resource.");

    private String text;

    Messages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
