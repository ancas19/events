package co.com.events.models.enums;

public enum Constants {

    VERIFICATION_EMAIL("VERIFICATION_EMAIL");

    private final String value;
     Constants(String value) {
        this.value = value;
     }

     public String getValue() {
            return value;
     }
}
