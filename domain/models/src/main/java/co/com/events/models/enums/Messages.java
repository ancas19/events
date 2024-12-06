package co.com.events.models.enums;

public enum Messages {
    //Error messages

    MESSAGE_EXCEPTION("An error occurred, please try again later or contact with support."),
    MESSAGE_ERROR_DATA_INCORRECT("The data is incorrect, please check the fields and try again."),
    MESSAGE_GENERAL_BAD_REQUEST("Bad Request"),
    MESSAGE_GENERAL_NOT_FOUND("Not Found"),
    MESSAGE_GENERAL_FORBIDDEN("Forbidden"),
    MESSAGE_GENERAL_UNAUTHORIZED("Unauthorized"),
    MESSAGE_USERNAME_ALREADY_EXISTS("The username you entered is incorrect. Please try again."),


    // Success messages
    MESSAGE_HEALTH_CHECK("Service is up and running"),
    MESSAGE_USERNAME_AVAILABLE("The username is available"),
    MESSAGE_CODE_VERIFIED("The code has been verified successfully"),
    MESSAGE_VERIFICATION_CODE("The verification code has been sent to your email"),;
    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
