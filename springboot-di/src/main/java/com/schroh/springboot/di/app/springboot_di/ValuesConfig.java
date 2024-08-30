package com.schroh.springboot.di.app.springboot_di;

import com.schroh.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.schroh.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

@Configuration
@PropertySources({
        @PropertySource(value="classpath:config.properties", encoding = "UTF-8"),

})
public class ValuesConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Primary
    @Bean
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
