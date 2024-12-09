package co.com.events.models.enums;

public enum Constants {

    VERIFY_CODE("VERIFY_CODE"),
    EMAIL_VERIFICATION("Email Verification"),
    CODE("CODE_%s"),
    JWT("JWT_%s"),
    ATTEMPT("ATTEMPT_%s"),
    NO("NO"),
    SI("SI"),;

    private final String value;
     Constants(String value) {
        this.value = value;
     }

     public String getValue() {
            return value;
     }
}
