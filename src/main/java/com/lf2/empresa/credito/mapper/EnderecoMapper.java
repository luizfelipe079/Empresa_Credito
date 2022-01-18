package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClienteMapper.class})
public interface EnderecoMapper
{
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    @Mapping(target = "cliente.enderecos", source = "cliente.enderecos", ignore = true)
    public EnderecoDto modelToDto(Endereco model);

    @Mapping(target = "cliente.enderecos", source = "cliente.enderecos", ignore = true)
    public Endereco dtoToModel(EnderecoDto dto);

}
