package com.springBoot.blogapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
            title = "Blogging Application : Backend Course",
            description = "This project is developed by Keshav Gour",
            version = "2.0",
            contact = @Contact(
                    name = "Keshav",
                    url = "https://localhost:5000.com/api",
                    email = "keshavg6797@gmail.com"
            )
    ),
    security = {@SecurityRequirement(name = "JWT")},
    servers = {@Server(url = "http://localhost:5000")}
)
@SecurityScheme(
    name = "JWT",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "Enter the JWT token in the following format: `your_token`"
)
@Configuration
public class SwaggerConfig {
    // No Docket bean required with springdoc-openapi, configurations are handled via annotations
}
