package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.model.Credito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClienteMapper.class})
public interface CreditoMapper
{
    CreditoMapper INSTANCE = Mappers.getMapper(CreditoMapper.class);

    @Mapping(target = "cliente.creditos", source = "cliente.creditos", ignore = true)
    public CreditoDto modelToDto(Credito model);

    @Mapping(target = "cliente.creditos", source = "cliente.creditos", ignore = true)
    public Credito dtoToModel(CreditoDto dto);
}
