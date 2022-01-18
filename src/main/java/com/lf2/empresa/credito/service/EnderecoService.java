package com.lf2.empresa.credito.service;

import com.lf2.empresa.credito.dto.EnderecoDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Endereco;
import com.lf2.empresa.credito.repository.ClienteRepository;
import com.lf2.empresa.credito.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService extends com.lf2.empresa.credito.service.Service<Endereco, EnderecoDto>
{
    private final EnderecoRepository repository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public EnderecoService(EnderecoRepository repository,
                           ClienteRepository clienteRepository)
    {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public Collection<EnderecoDto> listar()
    {
        return super.getAll();
    }

    public EnderecoDto findById(Long id)
    {
        return super.getById(id);
    }

    public EnderecoDto novo(Long id, EnderecoDto dto)
    {
        Cliente byId = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException());
        dto.setCliente(byId);

        byId.addEndereco(dto.dtoToModel());
        clienteRepository.save(byId);

        return super.create(dto);
    }

    public EnderecoDto alterar(Long id, EnderecoDto dto)
    {
        EnderecoDto att = repository.findById(id).orElseThrow(() -> new RuntimeException()).modelToDto();
        dto = objetoAtualizado(att, dto);

        return super.update(dto);
    }

    private EnderecoDto objetoAtualizado(EnderecoDto dto, EnderecoDto dtoAtt)
    {
        if(dtoAtt.getCep() != null)
        {
            dto.setCep(dtoAtt.getCep());
        }
        if(dtoAtt.getEstado() != null)
        {
            dto.setEstado(dtoAtt.getEstado());
        }
        if(dtoAtt.getCidade() != null)
        {
            dto.setCidade(dtoAtt.getCidade());
        }
        if(dtoAtt.getBairro() != null)
        {
            dto.setBairro(dtoAtt.getBairro());
        }
        if(dtoAtt.getLogradouro() != null)
        {
            dto.setLogradouro(dtoAtt.getLogradouro());
        }
        if(dtoAtt.getNumero() != null)
        {
            dto.setNumero(dtoAtt.getNumero());
        }

        return dto;
    }

    public void deletar(Long id)
    {
        super.delete(id);
    }

    @Override
    protected CrudRepository<Endereco, Long> getRepository()
    {
        return repository;
    }

}
