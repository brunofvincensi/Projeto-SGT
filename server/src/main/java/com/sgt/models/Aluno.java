package com.sgt.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @ManyToOne
    private Turma turma;


    public Aluno(String nome, String cpf, Turma turma) {
        this.nome = nome;
        this.cpf = cpf;
        this.turma = turma;

    }
}
