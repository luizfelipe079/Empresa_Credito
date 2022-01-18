package com.lf2.empresa.credito.controller;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/clientes")
public class ClienteController
{
    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service)
    {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/lista")
    public Collection<ClienteDto> listar()
    {
        return service.listar();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public ClienteDto findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ClienteDto novo(@RequestBody ClienteDto dto)
    {
        return service.novo(dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public ClienteDto alterar(@PathVariable Long id, @RequestBody ClienteDto dto)
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
