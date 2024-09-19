package com.schroh.springboot.jpa.springboot_jpa_relationship.repositories;

import com.schroh.springboot.jpa.springboot_jpa_relationship.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
  // Obtenermos las direcciones de los clientes mediante fetch
   @Query("select c from Client c left join fetch c.addresses where c.id=?1")
    Optional<Client> findOneWithAddresses(Long id);

   @Query("select c from Client c left join fetch c.invoices where c.id=?1") // con LEFT join trae a el cliente tenga o no facturas
    Optional<Client> findOneInvoices(Long id);

    @Query("select c from Client c left join fetch c.invoices where c.id=?1") // con LEFT join trae a el cliente tenga o no facturas
    Optional<Client> findOne(Long id);
}
