package com.lf2.empresa.credito.service;

import com.lf2.empresa.credito.dto.ClienteDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.repository.ClienteRepository;
import com.lf2.empresa.credito.repository.CreditoRepository;
import com.lf2.empresa.credito.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService extends com.lf2.empresa.credito.service.Service<Cliente, ClienteDto>
{
    private final ClienteRepository repository;
    private final EnderecoRepository enderecoRepository;
    private final CreditoRepository creditoRepository;

    @Autowired
    public ClienteService(ClienteRepository repository,
                          EnderecoRepository enderecoRepository,
                          CreditoRepository creditoRepository)
    {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
        this.creditoRepository = creditoRepository;
    }

    public Collection<ClienteDto> listar()
    {
        return super.getAll();
    }

    public ClienteDto findById(Long id)
    {
        return super.getById(id);
    }

    public ClienteDto novo(ClienteDto dto)
    {
        return super.create(dto);
    }

    public ClienteDto alterar(Long id, ClienteDto dto)
    {
        ClienteDto att = repository.findById(id).orElseThrow(() -> new RuntimeException()).modelToDto();
        dto = objetoAtualizado(att, dto);

        return super.update(dto);
    }

    public void deletar(Long id)
    {
        super.delete(id);
    }

    public ClienteDto objetoAtualizado(ClienteDto dto, ClienteDto dtoAtt)
    {
        if (dtoAtt.getNome() != null){
            dto.setNome(dtoAtt.getNome());
        }
        if (dtoAtt.getEmail() != null){
            dto.setEmail(dtoAtt.getEmail());
        }
        if (dtoAtt.getCpf() != null){
            dto.setCpf(dtoAtt.getCpf());
        }
        if (dtoAtt.getRenda() != null){
            dto.setRenda(dtoAtt.getRenda());
        }
        if (dtoAtt.getRg() != null){
            dto.setRg(dtoAtt.getRg());
        }

        return dto;
    }

    @Override
    protected CrudRepository<Cliente, Long> getRepository()
    {
        return repository;
    }

}
