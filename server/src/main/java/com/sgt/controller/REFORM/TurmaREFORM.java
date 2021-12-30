package com.sgt.controller.REFORM;

import com.sgt.models.Aluno;
import com.sgt.models.Turma;
import com.sgt.repositories.TurmaRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TurmaREFORM {




    private String horario;
    private String periodo;
    private String nome;
    private int quantidadeAluno;





    public Turma atualizar(Long id, TurmaRepository turmaRepository) {

        Turma turma = turmaRepository.getById(id);

        turma.setHorario(this.horario);
        turma.setPeriodo(this.periodo);
        turma.setNome(this.nome);
        turma.setQuantidadeAluno(this.quantidadeAluno);


        return turma;
    }
}
