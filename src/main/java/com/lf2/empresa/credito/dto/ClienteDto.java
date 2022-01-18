package com.lf2.empresa.credito.dto;

import com.lf2.empresa.credito.base.ModelDto;
import com.lf2.empresa.credito.mapper.ClienteMapper;
import com.lf2.empresa.credito.model.Cliente;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class ClienteDto extends ModelDto<Cliente> implements Serializable
{
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private Double renda;
    private String senha;
    private Collection<EnderecoDto> enderecos;
    private Collection<CreditoDto> creditos;

    public Cliente dtoToModel()
    {
        return ClienteMapper.INSTANCE.dtoToModel(this);
    }
}
