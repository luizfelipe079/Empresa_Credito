package com.lf2.empresa.credito.controller;

import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController
{
    private final EnderecoService service;

    @Autowired
    public EnderecoController(EnderecoService service)
    {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/lista")
    public Collection<EnderecoDto> listar()
    {
        return service.listar();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public EnderecoDto findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/{clienteId}")
    public EnderecoDto novo(@PathVariable Long clienteId, @RequestBody EnderecoDto dto)
    {
        return service.novo(clienteId,dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public EnderecoDto alterar(@PathVariable Long id, @RequestBody EnderecoDto dto)
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
