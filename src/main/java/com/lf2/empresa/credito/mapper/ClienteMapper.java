package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {EnderecoMapper.class, CreditoMapper.class})
public interface ClienteMapper
{
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public ClienteDto modelToDto(Cliente model);

    public Cliente dtoToModel(ClienteDto dto);
}
