package co.com.events.controllers;

import co.com.events.responses.GeneralResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static co.com.events.models.enums.Messages.MESSAGE_HEALTH_CHECK;

@RequestMapping("/health")
@RestController
@Tag(name = "Health")
public class HealthController {

    @GetMapping()
    public ResponseEntity<GeneralResponse<String>> health() {
        return ResponseEntity.ok(
                GeneralResponse.<String>builder()
                        .response(MESSAGE_HEALTH_CHECK.getMessage())
                        .message(MESSAGE_HEALTH_CHECK.getMessage())
                        .build()

        );
    }
}
