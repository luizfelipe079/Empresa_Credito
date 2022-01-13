package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.model.Credito;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditoMapper
{
    CreditoMapper INSTANCE = Mappers.getMapper(CreditoMapper.class);

    public CreditoDto modelToDto(Credito model);

    public Credito dtoToModel(CreditoDto dto);
}
