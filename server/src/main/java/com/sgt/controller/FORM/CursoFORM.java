package com.sgt.controller.FORM;

import com.sgt.models.Curso;
import com.sgt.models.Professor;
import com.sgt.repositories.CursoRepository;
import com.sgt.repositories.ProfessorRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CursoFORM {

    private String nome;


    private Double valorCurso;


    private String regulamentacao;


    private String conteudoProgramatico;


    public Curso converter(CursoRepository cursoRepository) {




        return new Curso(nome, valorCurso, regulamentacao, conteudoProgramatico);
    }
}
