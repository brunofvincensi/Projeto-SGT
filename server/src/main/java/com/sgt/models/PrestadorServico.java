package com.sgt.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String nome;
    private String cnpj;
    private int numero;
    private String cep;
    private String cidade;



    public PrestadorServico(String razaoSocial, String nome, String cnpj, int numero, String cep, String cidade) {
        this.razaoSocial = razaoSocial;
        this.nome = nome;
        this.cnpj = cnpj;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;

    }
}
