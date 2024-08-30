package com.schroh.springboot.di.app.springboot_di.services;

import com.schroh.springboot.di.app.springboot_di.models.Product;
import com.schroh.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.schroh.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service // Service no provee nada mas que una semantica, un nombre.
public class ProductServiceImpl implements ProductService{

    @Value("${config.taxes}")
    private double taxes;

     // Principio Hollywood
//    @Autowired                En caso de no utilzar constructos el Qualifier se utiliza asi
//    @Qualifier("productFoo")
    private ProductRepository repository; // Tenemos que siempre trabajar en base a la inyeccion de interfaces para desacoplar lo mas posible a nuestro programa.

    // En este caso tenemos dos repositorios que implementan la misma interfaz, nosotros inyectamos dicha interfaz, entonces asignamos el Primary al Repository que querramos y con Qualifier seleccionamos que repo inyectar.
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) { // Podemos inyectar mediante el constructor de la interfaz, es lo mismo que utilizar autowired
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
                Double priceTax = p.getPrice() * this.taxes;

                Product newProd = (Product) p.clone(); // crea un clon o copia del objeto original
                newProd.setPrice(priceTax.longValue()); // El tema de que sea clonado es que lo hace 100% inmutable
                return newProd;
//
//                p.setPrice(priceTax.longValue());
//                return p;


        }).collect(Collectors.toList()); // el metodo collect con Collectors.toList() transforma nuestro producto en una lista
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
