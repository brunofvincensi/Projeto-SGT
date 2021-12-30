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
public class Turma {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horario;
    private String periodo;
    private String nome;
    private int quantidadeAluno;


    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Cliente cliente;


    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();


    //private List<ListaChamada> listasChamada = new ArrayList<>();


    public Turma(String horario, String periodo, String nome, int quantidadeAluno, Curso curso, Professor professor, Cliente cliente) {
        this.horario = horario;
        this.periodo = periodo;
        this.nome = nome;
        this.quantidadeAluno = quantidadeAluno;
        this.curso = curso;
        this.professor = professor;
        this.cliente = cliente;
    }


}
