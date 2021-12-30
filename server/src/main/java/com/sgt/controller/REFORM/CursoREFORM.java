package com.sgt.controller.REFORM;

import com.sgt.models.Curso;
import com.sgt.repositories.CursoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoREFORM {

    private String nome;
    private Double valorCurso;
    private String regulamentacao;
    private String conteudoProgramatico;


    public Curso atualizar(Long id, CursoRepository cursoRepository) {



        Curso curso = cursoRepository.getById(id);

        curso.setNome(this.nome);
        curso.setValorCurso(this.valorCurso);
        curso.setRegulamentacao(this.regulamentacao);
        curso.setConteudoProgramatico(this.conteudoProgramatico);

        return curso;

    }
}
