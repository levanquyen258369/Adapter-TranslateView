package com.example.CodeBase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public GroupedOpenApi openApiGroup(){
        return GroupedOpenApi.builder()
                .group("Api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI apiInfomation(){
        return new OpenAPI().info(
                new Info().title("Chuyển đổi API")
                        .description("Ví dụ về Rest Api cho Chuyển đổi ứng dụng web")
                        .version("1.0")
        );
    }
}
