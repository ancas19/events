package co.com.events.reponses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GeneralResponse<T> {
    private String message;
    private T response;
}
