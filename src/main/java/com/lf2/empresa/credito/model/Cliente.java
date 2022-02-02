package com.lf2.empresa.credito.model;

import com.lf2.empresa.credito.base.Model;
import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.mapper.ClienteMapper;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente extends Model<ClienteDto> implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private Collection<Endereco> enderecos;

    @Column(name = "RENDA")
    private Double renda;

    @Column(name = "SENHA")
    private String senha;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Collection<Credito> creditos;

    public Boolean addEndereco(Endereco endereco)
    {
        if (this.enderecos == null)
        {
            this.enderecos = new HashSet<>();
        }

        return this.enderecos.add(endereco);
    }

    public Boolean addCredito(Credito credito)
    {
        if(this.creditos == null)
        {
            this.creditos = new HashSet<>();
        }

        return this.creditos.add(credito);
    }

    public ClienteDto modelToDto()
    {
        return ClienteMapper.INSTANCE.modelToDto(this);
    }
}
