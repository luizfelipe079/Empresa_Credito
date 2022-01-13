package com.lf2.empresa.credito.model;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.mapper.ClienteMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Cliente implements Serializable
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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Collection<Endereco> enderecos = new HashSet<>();

    @Column(name = "RENDA")
    private Double renda;

    @Column(name = "SENHA")
    private String senha;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Collection<Credito> creditos = new HashSet<>();

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
