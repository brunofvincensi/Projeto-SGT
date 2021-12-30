package com.sgt.controller.FORM;

import com.sgt.models.Aluno;
import com.sgt.models.Curso;
import com.sgt.models.Turma;
import com.sgt.repositories.AlunoRepository;
import com.sgt.repositories.TurmaRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
public class AlunoFORM {


    private String nome;

   // @NotNull
   // @NotEmpty
    private String cpf;

    private String nomeTurma;




    public Aluno converter(TurmaRepository turmaRepository) {

        Turma turma = turmaRepository.findByNome(nomeTurma);


        return new Aluno(nome, cpf, turma);

    }
}
