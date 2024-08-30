package com.schroh.springboot.di.app.springboot_di.repositories;

import com.schroh.springboot.di.app.springboot_di.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor", 520L)); // Una unica lista
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor", 520L);
    }
}
