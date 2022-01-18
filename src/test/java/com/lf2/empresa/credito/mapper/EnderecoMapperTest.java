package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Endereco;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnderecoMapperTest
{
    EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

    Endereco endereco;
    EnderecoDto enderecoDto;

    @BeforeAll
    void init()
    {
        endereco = new Endereco();
        endereco.setId(1L);
        endereco.setEstado("PE");
        endereco.setCidade("Recife");
        endereco.setBairro("Boa viagem");
        endereco.setLogradouro("Rua 1");
        endereco.setNumero(1);
        endereco.setCep("123456789");

        enderecoDto = new EnderecoDto();
        enderecoDto.setId(1L);
        enderecoDto.setEstado("PE");
        enderecoDto.setCidade("Recife");
        enderecoDto.setBairro("Boa viagem");
        enderecoDto.setLogradouro("Rua 1");
        enderecoDto.setNumero(1);
        enderecoDto.setCep("123456789");

        Cliente cliente = new Cliente();
        cliente.setId(10L);

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(10L);
    }

    @Test
    @Order(1)
    void modelToDto()
    {
        EnderecoDto dto = enderecoMapper.modelToDto(endereco);

        assertEquals(1L, dto.getId());
    }

    @Test
    @Order(2)
    void dtoToModel()
    {
        Endereco model = enderecoMapper.dtoToModel(enderecoDto);

        assertEquals(1L, model.getId());
    }

    @Test
    @Order(3)
    void NullId()
    {
        enderecoDto.setId(null);
        Endereco model = enderecoMapper.dtoToModel(enderecoDto);

        assertEquals(null, model.getId());
    }

}