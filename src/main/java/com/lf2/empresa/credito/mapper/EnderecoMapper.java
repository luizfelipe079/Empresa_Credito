package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper
{
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    public EnderecoDto modelToDto(Endereco model);

    public Endereco dtoToModel(EnderecoDto dto);

}
