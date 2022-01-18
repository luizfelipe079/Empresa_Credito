package com.lf2.empresa.credito.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lf2.empresa.credito.base.ModelDto;
import com.lf2.empresa.credito.mapper.CreditoMapper;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import lombok.Data;

import java.util.Date;

@Data
public class CreditoDto extends ModelDto<Credito>
{
    private Long id;

    @JsonIgnore
    private Cliente cliente;

    private Double valor;

    @JsonFormat(pattern = "dd/MM/YYYY")
    private Date dataPrimeiraParcela;

    private Integer numParcelas;

    public Credito dtoToModel()
    {
        return CreditoMapper.INSTANCE.dtoToModel(this);
    }
}
