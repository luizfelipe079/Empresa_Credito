package com.lf2.empresa.credito.service;

import com.lf2.empresa.credito.dto.CreditoDto;
import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import com.lf2.empresa.credito.repository.ClienteRepository;
import com.lf2.empresa.credito.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CreditoService extends com.lf2.empresa.credito.service.Service<Credito, CreditoDto>
{
    private final CreditoRepository repository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public CreditoService(CreditoRepository repository,
                          ClienteRepository clienteRepository)
    {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public Collection<CreditoDto> listar()
    {
        return super.getAll();
    }

    public CreditoDto findById(Long id)
    {
        return super.getById(id);
    }

    public CreditoDto novo(Long id, CreditoDto dto)
    {
        Cliente byId = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException());
        dto.setCliente(byId);

        byId.addCredito(dto.dtoToModel());
        clienteRepository.save(byId);

        return super.create(dto);
    }

    public CreditoDto alterar(Long id, CreditoDto dto)
    {
        CreditoDto att = repository.findById(id).orElseThrow(() -> new RuntimeException()).modelToDto();
        dto = objetoAtualizado(att, dto);

        return super.update(dto);
    }

    public void deletar(Long id)
    {
        super.delete(id);
    }

    private CreditoDto objetoAtualizado(CreditoDto dto, CreditoDto dtoAtt)
    {
        if (dtoAtt.getValor() != null)
        {
            dto.setValor(dtoAtt.getValor());
        }
        if (dtoAtt.getNumParcelas() != null)
        {
            dto.setNumParcelas(dtoAtt.getNumParcelas());
        }
        if (dtoAtt.getDataPrimeiraParcela() != null)
        {
            dto.setDataPrimeiraParcela(dtoAtt.getDataPrimeiraParcela());
        }

        return dto;
    }

    @Override
    protected CrudRepository<Credito, Long> getRepository()
    {
        return repository;
    }

}
