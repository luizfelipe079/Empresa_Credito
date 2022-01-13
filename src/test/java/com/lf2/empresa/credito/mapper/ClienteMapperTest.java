package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import com.lf2.empresa.credito.model.Endereco;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClienteMapperTest
{
    ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

    Cliente cliente;
    ClienteDto dto;

    @BeforeAll
    void init()
    {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Luiz Felipe");
        cliente.setEmail("luiz@gmail.com");
        cliente.setCpf("12345678910");
        cliente.setRg("1234567");
        cliente.setSenha("1234");
        cliente.setRenda(1500.00);

        Endereco endereco = new Endereco();
        endereco.setId(2L);

        Credito credito = new Credito();
        credito.setId(3L);

        cliente.addEndereco(endereco);
        cliente.addCredito(credito);

        dto = new ClienteDto();
        dto.setId(1L);
        dto.setNome("Luiz Felipe");
        dto.setEmail("luiz@gmail.com");
        dto.setCpf("12345678910");
        dto.setRg("1234567");
        dto.setSenha("1234");
        dto.setRenda(1500.00);

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setId(2L);
        Collection<EnderecoDto> enderecoDtos = new HashSet<>();
        enderecoDtos.add(enderecoDto);

        CreditoDto creditoDto = new CreditoDto();
        creditoDto.setId(3L);
        Collection<CreditoDto> creditoDtos = new HashSet<>();
        creditoDtos.add(creditoDto);

        dto.setEnderecos(enderecoDtos);
        dto.setCreditos(creditoDtos);


    }

    @Test
    @Order(1)
    void modelToDto()
    {
        ClienteDto clienteDto = clienteMapper.modelToDto(cliente);

        assertEquals(1L, clienteDto.getId());
        assertFalse(clienteDto.getEnderecos().isEmpty());
        assertFalse(clienteDto.getCreditos().isEmpty());
    }

    @Test
    @Order(2)
    void dtoToModel()
    {
        Cliente model = clienteMapper.dtoToModel(dto);

        assertEquals(1L, cliente.getId());
        assertFalse(model.getEnderecos().isEmpty());
        assertFalse(model.getCreditos().isEmpty());
    }

    @Test
    @Order(3)
    void nullIdTest()
    {
        dto.setId(null);
        Cliente model = clienteMapper.dtoToModel(dto);

        assertEquals(null, model.getId());

    }

}