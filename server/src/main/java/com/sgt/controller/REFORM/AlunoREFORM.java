package com.sgt.controller.REFORM;

import com.sgt.models.Aluno;
import com.sgt.repositories.AlunoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoREFORM {
    private String nome;
    private String cpf;


    public Aluno atualizar(Long id, AlunoRepository alunoRepository) {

        Aluno aluno = alunoRepository.getById(id);
        aluno.setNome(this.nome);
        aluno.setCpf(this.cpf);


        return aluno;


    }
}
