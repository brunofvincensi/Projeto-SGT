package com.sgt.controller.DTO;

import com.sgt.models.Aluno;
import com.sgt.models.Curso;
import com.sgt.models.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DetalheTurmaDTO {
    private String horario;
    private String periodo;
    private String nome;
    private Curso nomeCurso;




    public DetalheTurmaDTO(Turma turma) {

        this.horario = turma.getHorario();
        this.periodo = turma.getPeriodo();
        this.nome = turma.getNome();
        this.nomeCurso = turma.getCurso();


    }





}
