package com.sgt.controller.FORM;

import com.sgt.models.Cliente;
import com.sgt.repositories.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFORM {


    private String razaoSocial;


    private String nome;



    private String cnpj;


    private String cidade;


    private int numero;



    private String cep;




    public Cliente converter(ClienteRepository clienteRepository) {





        return new Cliente(razaoSocial, nome, cnpj, numero, cep, cidade);


    }
}
