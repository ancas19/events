package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CodeVerification {
    private String code;
    private String email;

    @Override
    public String toString() {
        return "CodeVerification{" +
                "code='" + code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
