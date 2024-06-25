package com.nexusnova.lifetravelapi.app.shared.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringFoxConfig {
    final String securitySchemeName = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://lifetravel-api-production.up.railway.app"))
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("Lifetravel API")
                        .version("1.0.0")
                        .description("""
                                Developers:
                                -Oliver Tuesta
                                -Lucas Ruiz
                                -Edgar Malca
                                -Dominik Mendoza
                                -Jose Ramos""")
                        .termsOfService("https://iot-lifetravel-firebase-token-gen.netlify.app")
                        .license(new License().name("GitHub Organization").url("https://github.com/NexusNova-IOT"))
                        .contact(new Contact()
                                .url("https://nexusnova-iot.github.io/landing-page/")
                                .name("Lifetravel Landing Page")));
    }
}
