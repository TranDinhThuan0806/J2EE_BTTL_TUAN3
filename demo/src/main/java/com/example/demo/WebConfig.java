package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ánh xạ đường dẫn trên web (ví dụ: /images/anh1.png) 
        // vào thẳng thư mục vật lý "static/images/" trong thư mục gốc của project
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:static/images/");
    }
}
