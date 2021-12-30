package com.sgt.controller.FORM;

import com.sgt.models.Professor;
import com.sgt.repositories.ProfessorRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class ProfessorFORM {


    private String nome;


    private String cpf;


    private String capacitacaoProfessor;



    public Professor converter(ProfessorRepository professorRepository) {


        return new Professor(nome, cpf, capacitacaoProfessor);


    }
}
