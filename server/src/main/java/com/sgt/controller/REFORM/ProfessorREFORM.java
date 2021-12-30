package com.sgt.controller.REFORM;

import com.sgt.models.Professor;
import com.sgt.repositories.ProfessorRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorREFORM {

    private String nome;
    private String capacitacaoProfessor;


    public Professor atualizar(Long id, ProfessorRepository professorRepository) {


        Professor professor = professorRepository.getById(id);

        professor.setNome(this.nome);
        professor.setCapacitacaoProfessor(this.capacitacaoProfessor);



        return professor;

    }
}
