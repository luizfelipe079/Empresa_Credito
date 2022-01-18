package com.lf2.empresa.credito.controller;

import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/creditos")
public class CreditoController
{

    private final CreditoService service;

    @Autowired
    public CreditoController(CreditoService service)
    {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/lista")
    public Collection<CreditoDto> listar()
    {
        return service.listar();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public CreditoDto findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/{clienteId}")
    public CreditoDto novo(@PathVariable Long clienteId, @RequestBody CreditoDto dto)
    {
        return service.novo(clienteId,dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public CreditoDto alterar(@PathVariable Long id, @RequestBody CreditoDto dto)
    {
        return service.alterar(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id)
    {
        service.deletar(id);
    }

}
