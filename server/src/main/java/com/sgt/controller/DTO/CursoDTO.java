package com.sgt.controller.DTO;

import com.sgt.models.Curso;
import com.sgt.models.PrestadorServico;
import com.sgt.models.Professor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@ToString
public class CursoDTO {


    private String nome;
    private Double valorCurso;
    private String regulamentacao;
    private String conteudoProgramatico;



    public CursoDTO(Curso curso) {
        this.nome = curso.getNome();
        this.valorCurso = curso.getValorCurso();
        this.regulamentacao = curso.getRegulamentacao();
        this.conteudoProgramatico = curso.getConteudoProgramatico();
    }

    public static List<CursoDTO> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
    }
}
