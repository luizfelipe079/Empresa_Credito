package com.lf2.empresa.credito.repository;

import com.lf2.empresa.credito.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>
{

}
