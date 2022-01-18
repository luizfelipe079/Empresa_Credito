package com.lf2.empresa.credito.model;

import com.lf2.empresa.credito.base.Model;
import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.mapper.EnderecoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENDERECO")
public class Endereco extends Model<EnderecoDto> implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "CEP")
    private String cep;

    public EnderecoDto modelToDto()
    {
        return EnderecoMapper.INSTANCE.modelToDto(this);
    }
}
