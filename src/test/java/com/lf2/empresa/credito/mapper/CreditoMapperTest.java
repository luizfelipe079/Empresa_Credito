package com.lf2.empresa.credito.mapper;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreditoMapperTest
{
    CreditoMapper creditoMapper = Mappers.getMapper(CreditoMapper.class);

    Credito credito;
    CreditoDto creditoDto;

    @BeforeAll
    void init() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        credito = new Credito();
        credito.setId(1L);
        credito.setValor(10000.00);
        credito.setNumParcelas(60);
        credito.setDataPrimeiraParcela(sdf.parse("22/04/2022"));

        Cliente cliente = new Cliente();
        cliente.setId(10L);
        credito.setCliente(cliente);

        creditoDto = new CreditoDto();
        creditoDto.setId(1L);
        creditoDto.setValor(10000.00);
        creditoDto.setNumParcelas(60);
        creditoDto.setDataPrimeiraParcela(sdf.parse("22/04/2022"));

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(10L);

    }

    @Test
    @Order(1)
    void modelToDto()
    {
        CreditoDto dto = creditoMapper.modelToDto(credito);

        assertEquals(1L, dto.getId());
    }

    @Test
    @Order(2)
    void dtoToModel()
    {
        Credito model = creditoMapper.dtoToModel(creditoDto);

        assertEquals(1L, model.getId());
        assertEquals(10L, model.getCliente().getId());
    }

    @Test
    @Order(3)
    void idNullTest()
    {
        creditoDto.setId(null);
        Credito model = creditoMapper.dtoToModel(creditoDto);

        assertEquals(null, model.getId());
    }

}