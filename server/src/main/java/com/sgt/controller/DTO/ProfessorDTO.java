package com.sgt.controller.DTO;

import com.sgt.models.Professor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@ToString
public class ProfessorDTO {


    private String capacitacaoProfessor;
    private String nome;
    private String cpf;

    public ProfessorDTO(Professor professor) {
        this.capacitacaoProfessor = professor.getCapacitacaoProfessor();
        this.nome = professor.getNome();
        this.cpf = professor.getCpf();
    }

    public static List<ProfessorDTO> converter(List<Professor> professores) {
        return professores.stream().map(ProfessorDTO::new).collect(Collectors.toList());
    }

}
