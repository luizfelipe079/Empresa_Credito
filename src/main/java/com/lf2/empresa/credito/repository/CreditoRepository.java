package com.lf2.empresa.credito.repository;

import com.lf2.empresa.credito.model.Credito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends CrudRepository<Credito, Long>
{

}
