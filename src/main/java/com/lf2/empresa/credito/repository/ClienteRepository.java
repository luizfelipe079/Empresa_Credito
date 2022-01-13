package com.lf2.empresa.credito.repository;

import com.lf2.empresa.credito.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>
{

}
