package com.internal.bms.hr.hrportal.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HR Portal API")
                        .version("1.0")
                        .description("API for HR Portal"))
                .components(new Components());
    }

    @Bean
    public GroupedOpenApi candidateApi() {
        return GroupedOpenApi.builder()
                .group("candidate")
                .pathsToMatch("/api/v1/candidates/**")
                .build();
    }
}
