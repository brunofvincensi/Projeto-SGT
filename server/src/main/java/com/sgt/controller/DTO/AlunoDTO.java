package com.sgt.controller.DTO;

import com.sgt.models.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@ToString
public class AlunoDTO {

    private String nome;
    private String cpf;


    public AlunoDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();


    }

    public static List<AlunoDTO> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }
}
