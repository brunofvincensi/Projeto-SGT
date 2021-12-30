package com.sgt.controller.FORM;

import com.sgt.models.*;
import com.sgt.repositories.ClienteRepository;
import com.sgt.repositories.CursoRepository;
import com.sgt.repositories.ProfessorRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class TurmaFORM {

    private String horario;


    private String periodo;


    private String nome;


    private int quantidadeAluno;




    private String nomeCurso;


    private String nomeProfessor;


    private String nomeCliente;








    public Turma converter(CursoRepository cursoRepository, ProfessorRepository professorRepository, ClienteRepository clienteRepository) {


        Curso curso = cursoRepository.findByNome(nomeCurso);
        Professor professor = professorRepository.findByNome(nomeProfessor);
        Cliente cliente = clienteRepository.findByNome(nomeCliente);

        return new Turma(horario, periodo, nome, quantidadeAluno, curso, professor, cliente);

    }

  /*  public Turma converter(ProfessorRepository professorRepository){


        Professor professor = professorRepository.findByNome(nomeProfessor);

        return new Turma(professor);



    }*/
}
