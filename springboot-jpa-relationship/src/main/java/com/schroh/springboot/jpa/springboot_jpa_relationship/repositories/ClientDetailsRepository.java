package com.schroh.springboot.jpa.springboot_jpa_relationship.repositories;

import com.schroh.springboot.jpa.springboot_jpa_relationship.entities.ClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {

}
