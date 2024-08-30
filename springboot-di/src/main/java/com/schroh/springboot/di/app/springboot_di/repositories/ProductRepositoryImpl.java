package com.schroh.springboot.di.app.springboot_di.repositories;

import com.schroh.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

// En este caso tenemos dos repository que seran inyectados como dependencias, utilizando la anotacion Primary decimos que repo deseamos inyectar.


// @RequestScope // Deja de implementar el patron Singleton, e implementa el Scope por Request, es decir que es atomico se ejecutan los valores por request, el ciclo de vida existira unicamente por request, luego se destruye
 // Instancia y guarda, utiliza el patron Singleton, una unica instancia para todo el programa

//@SessionScope  Nos sirve para mantener la sesion del usuario activa, al cerrar pestania o recargar pagina no se pierdan los datos, esto nos sirve para un login, carro de compras, etc.
@Primary
@Repository("productList") // Componente de acceso a datos, nos sirve ya que utilizando la anotacion se Spring Boot maneja de manera mas legibles las excepciones desde SQL
public class ProductRepositoryImpl implements ProductRepository { // En el repository unicamente obtenemos y leemos datos, no interactua con el controlador, sino que lo hace el service

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L,"Memoria Kingston 8",300L),
                new Product(2L, "Cpu AMD Ryzen 9", 990L),
                new Product(3L, "Teclado Razer Blackwidow V2", 220L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id){
       return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
