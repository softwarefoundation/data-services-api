package br.com.devchampions.dataservices.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value(value = "${spring.application.version}")
    private String appVersion;

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("Data Services API")
                .description("Data Services API - Documentação de acesso aos endpoints").version(appVersion);
    }


}
