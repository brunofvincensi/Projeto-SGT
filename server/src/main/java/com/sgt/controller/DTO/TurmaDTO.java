package com.sgt.controller.DTO;

import com.sgt.models.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString

public class TurmaDTO {

    private String horario;
    private String periodo;
    private String nome;
    private String nomeCurso;
    private String nomeProfessor;
    private String nomeCliente;
    private List<AlunoDTO> alunos;




    public TurmaDTO(Turma turma) {
        this.horario = turma.getHorario();
        this.periodo = turma.getPeriodo();
        this.nome = turma.getNome();
        this.nomeCurso = turma.getCurso().getNome();
        this.nomeProfessor = turma.getProfessor().getNome();
        this.nomeCliente = turma.getCliente().getNome();
        this.alunos = new ArrayList<>();
        this.alunos.addAll(turma.getAlunos().stream().map(AlunoDTO::new).collect(Collectors.toList()));

    }

    public static List<TurmaDTO> converter(List<Turma> turmas) {
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }
}
