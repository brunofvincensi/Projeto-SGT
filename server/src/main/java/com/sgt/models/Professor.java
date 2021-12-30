package com.sgt.models;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Professor{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String capacitacaoProfessor;



    public Professor(String nome, String cpf, String capacitacaoProfessor) {
        this.nome = nome;
        this.cpf = cpf;
        this.capacitacaoProfessor = capacitacaoProfessor;
    }
}
