package edu.practice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI UserMicroserviceOpenApi(){
        return new OpenAPI().info(
                new Info().title("Titulo de mi api rest")
                        .description("Descripcion de mi api rest")
                        .version("VERSION 1")
                        .contact(
                                new Contact().email("jphuauya@hotmail.com")
                                        .name("joan15")
                        )
                        .license(
                                new License().name("APACHE 2.0")
                                        .url("http://www.apache.org/Licenses/LICENSE-2.0.html")
                        )
        );

    }

}
