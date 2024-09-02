package com.schroh.di.factura.springboot_difactura.controllers;

import com.schroh.di.factura.springboot_difactura.models.Client;
import com.schroh.di.factura.springboot_difactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices") // Predeterminadamente los request son Singleton, es decir la misma instancia en todo el programa, por ende si un cliente modifica una linea de la factura esta se modifica para todos
public class InvoiceController { // Es decir si un cliente agrega en su carro de compra un producto, ese producto se agrega a todos los carros de compra de todos los usuarios
// Entonces para esto necesitamos manejar los Scopes o Contextos de los componentes

    @Autowired
    private Invoice invoice; // Inyecta un proxy, no es un objeto original, si no que son Proxys para mantener el estado por cada cliente

    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice(); // Tenemos que crear estas instancias si no utilizariamos el proxy
        Client c = new Client();
        c.setLastName(invoice.getClient().getLastName());
        c.setName(invoice.getClient().getName());
        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    }
}
