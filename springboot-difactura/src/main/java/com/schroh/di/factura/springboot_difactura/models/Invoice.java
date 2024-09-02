package com.schroh.di.factura.springboot_difactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
//@ApplicationScope // Si tenemos varias apliaciones en Tomcat podemos inyectarles componentes y que se combinen entre aplicaciones.
@RequestScope // Con esta anotacion de Spring generamos un Proxy
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice { // La factura posee items

    @Autowired   // Client fue definido como un componente, entonces utilziamos autowired para desacoplar Invoice
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("iOffice")
    private List<Item> items; // List no podemos inyectarla porque es una interfaz de java

    // METODOS DEL CICLO DE VIDA DEL COMPONENTE

    public Invoice() { // Que diferencia hay entre crear el constructor de la clase o utilizar "PostConstruct" ? La diferencia es que el constructor normal no tendra las dependencias inyectadas, por lo cual no podriamos laburar con ellas.
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Enzo"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(client.getLastName());
    }

    @PreDestroy // Al finalizar el compnente Invoice lo que hace es que cuando se antes de cerrar la sesion haga determinada cosa, normalmente se hace una limpieza
    public void destroy(){
        System.out.println("Destruyendo el bean invoice!");
    }

    //////////////////////////////////////////

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {

        return items.stream()
                    .mapToInt(Item::getImporte)
                    .sum();
    }
}
