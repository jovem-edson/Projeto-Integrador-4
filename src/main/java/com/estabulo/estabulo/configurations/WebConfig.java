package com.estabulo.estabulo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configurar o Spring Boot para servir imagens da pasta 'uploads/'
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}