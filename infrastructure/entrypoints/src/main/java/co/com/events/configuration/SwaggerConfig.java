package co.com.events.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Events API")
                                .description("Events API")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("andres@email.com")
                                                .name("Andres")


                                )
                );
    }
}
