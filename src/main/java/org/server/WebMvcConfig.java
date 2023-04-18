package org.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/teacher/**").addResourceLocations("file:E:\\springboot_save_file\\teacher\\");
        registry.addResourceHandler("/student/**").addResourceLocations("file:E:\\springboot_save_file\\student\\");
    }
}