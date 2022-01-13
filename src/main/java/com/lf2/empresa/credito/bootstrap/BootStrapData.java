package com.lf2.empresa.credito.bootstrap;

import com.lf2.empresa.credito.model.Cliente;
import com.lf2.empresa.credito.model.Credito;
import com.lf2.empresa.credito.model.Endereco;
import com.lf2.empresa.credito.repository.ClienteRepository;
import com.lf2.empresa.credito.repository.CreditoRepository;
import com.lf2.empresa.credito.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner
{

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CreditoRepository creditoRepository;

    @Autowired
    public BootStrapData(ClienteRepository clienteRepository,
                         EnderecoRepository enderecoRepository,
                         CreditoRepository creditoRepository)
    {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.creditoRepository = creditoRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Started in BootStrap");

        Cliente cliente = new Cliente();
        cliente.setNome("Luiz Felipe");
        cliente.setEmail("luiz@gmail.com");
        cliente.setCpf("12345678910");
        cliente.setRg("1234567");
        cliente.setSenha("1234");
        cliente.setRenda(1500.00);

        Endereco endereco = new Endereco();
        endereco.setEstado("Pernambuco");
        endereco.setCidade("Recife");
        endereco.setBairro("Cordeiro");
        endereco.setLogradouro("Rua Barros");
        endereco.setNumero(100);
        endereco.setCep("12345678910");

        endereco.setCliente(cliente);
        cliente.getEnderecos().add(endereco);

        clienteRepository.save(cliente);
        enderecoRepository.save(endereco);

        Credito credito = new Credito();
        credito.setValor(10000.00);
        credito.setNumParcelas(60);

        credito.setCliente(cliente);
        cliente.getCreditos().add(credito);

        creditoRepository.save(credito);
    }

}
