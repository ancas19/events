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
    MESSAGE_PASSWORDS_DO_NOT_MATCH("The passwords do not match. Please try again."),
    MESSAGE_ROLE_NOT_FOUND("The role was not found"),
    MESSAGE_PHONE_NUMBER_ALREADY_EXISTS("Already exists a user with the phone number entered"),
    MESSAGE_EMAIL_ALREADY_EXISTS("Email not available"),
    MESSAGE_PASSWORD_ALREADY_EXISTS("The password already exists"),
    MESSAGE_USER_NOT_FOUND("User not exist"),
    MESSAGE_LOGIN_FAILED("Login failed"),
    MESSAGE_EMAIL_NOT_VERIFIED("The email has not been verified"),
    MESSAGE_PEOPLE_NOT_FOUND("People information not found"),



    // Success messages
    MESSAGE_HEALTH_CHECK("Service is up and running"),
    MESSAGE_LOGIN_SUCCESS("Login success"),
    MESSAGE_USERNAME_AVAILABLE("The username is available"),
    MESSAGE_CODE_VERIFIED("The code has been verified successfully"),
    MESSAGE_VERIFICATION_CODE("The verification code has been sent to your email"),
    MESSAGE_ACCOUNT_CREATED("The account has been created successfully"), ;
    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
