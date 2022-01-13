package com.lf2.empresa.credito.dto;

import com.lf2.empresa.credito.mapper.CreditoMapper;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import lombok.Data;

import java.util.Date;

@Data
public class CreditoDto
{
    private Long id;
    private Double valor;
    private Date dataPrimeiraParcela;
    private Integer numParcelas;
    private Cliente cliente;

    public Credito dtoToModel()
    {
        return CreditoMapper.INSTANCE.dtoToModel(this);
    }
}
