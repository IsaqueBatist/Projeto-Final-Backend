package br.gov.sp.itu.fatec.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Contatos")
                .version("1.0")
                .description("API para gerenciamento de contatos, categorias, grupos, endereços, etc.")
                .contact(new Contact()
                    .name("Isaque Barbosa")
                    .email("isaquebatista400@gmail.com")));
    }
}