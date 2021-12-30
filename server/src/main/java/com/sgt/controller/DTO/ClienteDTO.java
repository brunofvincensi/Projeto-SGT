package com.sgt.controller.DTO;

import com.sgt.models.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@ToString
public class ClienteDTO {


    private String razaoSocial;
    private String nome;
    private String cnpj;
    private String cidade;

    public ClienteDTO(Cliente cliente) {
        this.razaoSocial = cliente.getRazaoSocial();
        this.nome = cliente.getNome();
        this.cnpj = cliente.getCnpj();
        this.cidade = cliente.getCidade();
    }



    public static List<ClienteDTO> converter(List<Cliente> clientes){

        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());

    }


}
