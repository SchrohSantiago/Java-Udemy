package com.schroh.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/baz"); // Podemos decidir en que rutas y en cuales no aplica el interceptor
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**"); aplica para todos los controladores de /app
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar", "/app/baz"); // para excluir las rutas en las cuales no queremos que se incluyan
    }
}
