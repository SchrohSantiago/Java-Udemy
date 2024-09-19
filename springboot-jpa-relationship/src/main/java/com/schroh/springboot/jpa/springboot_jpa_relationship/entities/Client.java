package com.schroh.springboot.jpa.springboot_jpa_relationship.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

//    @OneToMany // UN CLIENTE POSEE MUCHAS FACTURAS
//    private List<Invoice> invoice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) // Agregamos un cliente y se agrega tambien la dire, o si eliminamos un cliente se elimina su direccion  y el orphan remove es para que se remueva la direccion por completa
//    @JoinColumn(name ="client_id") // El join column evita que se cree una tabla intermedio y creara la Foregin Key "client_id" en la tabla addresses, PERO SI LA RELACION ES BI DIRECCIONAL NO PUEDE ESTAR
    @JoinTable(name = "tbl_clientes_to_direcciones",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_direcciones"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"}))
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client") // con MappedBy definimos la relacion inversa, debe ser el mismo nombre del atributo de tipo Cliente
    private Set<Invoice> invoices;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client") // La clase padre sera el Cliente ya que establecemos los parametros que se ven, mappedBy establece la relacion bidireccional
    // JoinColumn no debe estar con mappedBy !
    private ClientDetails clientDetails;

    public Client() {
        addresses = new HashSet<>();
        invoices = new HashSet<>();
    }

    public Client(String lastName, String name) {
        this();
        this.lastName = lastName;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(HashSet<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(HashSet<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Client addInvoice(Invoice invoice){
        invoices.add(invoice);
        invoice.setClient(this); // Le seteamos el cliente del scope
        return this; // nos permite encadenar el metodo add
    }

    public Client removeInvoice(Invoice invoice) {
        invoices.remove(invoice);
        invoice.setClient(null);
        return this;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
        clientDetails.setClient(this); // Establecemos la relacion inversa
    }

    public void removeClientDetails(ClientDetails clientDetails) {
        clientDetails.setClient(null);
        this.clientDetails = null;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addresses='" + addresses + '\'' +
                ", invoices='" + invoices + '\'' +
                ", clientDetails='" + clientDetails + '\'' +
                '}';
    }


}
