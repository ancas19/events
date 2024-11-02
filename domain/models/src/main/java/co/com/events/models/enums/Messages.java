package co.com.events.models.enums;

public enum Messages {
    MESSAGE_HEALTH_CHECK("Service is up and running");
    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
