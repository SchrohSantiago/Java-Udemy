package com.schroh.di.factura.springboot_difactura;

import com.schroh.di.factura.springboot_difactura.models.Item;
import com.schroh.di.factura.springboot_difactura.models.Product;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("iNormal")
    List<Item> itemsInvoice() {
        Product p1 = new Product("PS5",499);
        Product p2 = new Product("XBOX-ONE",479);

        return Arrays.asList(new Item(p1,2),new Item(p2,5));
    }

    @Bean("iOffice")
//    @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor LG 27",249);
        Product p2 = new Product("Teclado Razer Blackwidow V2",130);
        Product p3 = new Product("Ryzen 5 3600, 3.8Ghz",86);

        return Arrays.asList(new Item(p1,2),new Item(p2,5), new Item(p3, 12));
    }
}
