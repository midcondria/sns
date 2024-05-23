package com.pawland.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SwaggerConfig {

    @Bean
    public OpenAPI serverApiConfig() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.description("백엔드 도메인");
        return new OpenAPI()
            .servers(List.of(server))
            .info(new Info().title("API Docs")
                .description("API SWAGGER UI입니다."));
    }
}
