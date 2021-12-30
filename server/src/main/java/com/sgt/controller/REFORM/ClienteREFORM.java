package com.sgt.controller.REFORM;

import com.sgt.models.Cliente;
import com.sgt.repositories.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class ClienteREFORM {
    @NotNull
    @NotEmpty
    private String razaoSocial;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String cnpj;

    @NotNull
    @NotEmpty
    private int numero;

    @NotNull
    @NotEmpty
    private String cep;

    @NotNull
    @NotEmpty
    private String dataCadastro;

    @NotNull
    @NotEmpty
    private String cidade;



    public Cliente atualizar(Long id, ClienteRepository clienteRepository) {

        Cliente cliente = clienteRepository.getById(id);
        cliente.setRazaoSocial(this.razaoSocial);
        cliente.setNome(this.nome);
        cliente.setCnpj(this.cnpj);
        cliente.setNumero(this.numero);
        cliente.setCep(this.cep);



        return cliente;


    }
}
