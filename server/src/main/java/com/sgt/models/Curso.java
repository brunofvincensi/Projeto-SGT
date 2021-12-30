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
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorCurso;
    private String regulamentacao;
    private String conteudoProgramatico;







    public Curso(String nome, Double valorCurso, String regulamentacao, String conteudoProgramatico) {
        this.nome = nome;
        this.valorCurso = valorCurso;
        this.regulamentacao = regulamentacao;
        this.conteudoProgramatico = conteudoProgramatico;

    }
}
