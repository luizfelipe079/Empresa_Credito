package com.lf2.empresa.credito.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lf2.empresa.credito.base.Model;
import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.mapper.CreditoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CREDITO")
public class Credito extends Model<CreditoDto>
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "DATA_PRIMEIRA_PARCELA")
    @JsonFormat(pattern = "dd/MM/YYYY")
    private Date dataPrimeiraParcela;

    @Column(name = "NUMERO_PARCELAS")
    private Integer numParcelas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    public CreditoDto modelToDto()
    {
        return CreditoMapper.INSTANCE.modelToDto(this);
    }
}
