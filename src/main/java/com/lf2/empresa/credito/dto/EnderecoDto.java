package com.lf2.empresa.credito.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lf2.empresa.credito.base.ModelDto;
import com.lf2.empresa.credito.mapper.EnderecoMapper;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Endereco;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnderecoDto extends ModelDto<Endereco> implements Serializable
{
    private Long id;

    @JsonIgnore
    private Cliente cliente;

    private String estado;

    private String cidade;

    private String bairro;

    private String logradouro;

    private Integer numero;

    private String cep;

    public Endereco dtoToModel()
    {
        return EnderecoMapper.INSTANCE.dtoToModel(this);
    }
}
