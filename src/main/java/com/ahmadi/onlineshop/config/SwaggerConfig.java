package com.ahmadi.onlineshop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Online shop application",
                description = "A sample project with spring boot ",
                termsOfService=" terms Of Service",
                version="1.0.0"
        ),
        servers= {
                @Server(
                        url = "http://localhost:8080/"
                ),
                @Server(
                        url = "http://localhost:9090/"
                )
        }
)
public class SwaggerConfig{

}