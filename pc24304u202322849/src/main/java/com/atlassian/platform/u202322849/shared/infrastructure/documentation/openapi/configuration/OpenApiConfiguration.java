package com.atlassian.platform.u202322849.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** OpenAPI documentation configuration.
 * @author Marlon Packard Viza Quispe
 */
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI atlassianOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Atlassian Access Requests API")
                .version("1.0.0")
                .description("REST API for registering employee access requests."));
    }
}
