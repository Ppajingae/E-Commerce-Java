package com.yoong.ecommercejava2.infra.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        OpenAPI openAPI = new OpenAPI();
        SecurityRequirement securityRequirement = new SecurityRequirement();
        Components components = new Components();
        SecurityScheme securityScheme = new SecurityScheme();
        Info info = new Info();

        openAPI.addSecurityItem(securityRequirement.addList("Bearer Authentication"))
                .components(components.addSecuritySchemes(
                        "Bearer Authentication",
                        securityScheme
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")))
                .info(info
                        .title("High-v API")
                        .description("high-v API description")
                        .version("1.0.0"));

        return openAPI;
    }
}
