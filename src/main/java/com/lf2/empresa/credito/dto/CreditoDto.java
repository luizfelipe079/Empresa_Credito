package com.lf2.empresa.credito.dto;

import com.lf2.empresa.credito.mapper.CreditoMapper;
import com.lf2.empresa.credito.model.Credito;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CreditoDto
{
    private Long id;

    private Double valor;

    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private Date dataPrimeiraParcela;

    private Integer numParcelas;

    private ClienteDto cliente;

    public Credito dtoToModel()
    {
        return CreditoMapper.INSTANCE.dtoToModel(this);
    }
}
