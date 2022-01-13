package com.lf2.empresa.credito.dto;

import com.lf2.empresa.credito.mapper.EnderecoMapper;
import com.lf2.empresa.credito.model.Endereco;
import lombok.Data;

@Data
public class EnderecoDto
{
    private Long id;
    private ClienteDto cliente;
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
