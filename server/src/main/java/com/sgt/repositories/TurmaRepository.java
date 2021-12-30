package com.sgt.repositories;
import com.sgt.models.Aluno;
import com.sgt.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository  extends JpaRepository<Turma, Long> {


    @Query("SELECT t FROM Turma t WHERE t.curso.nome = :nomeCurso  ")
    List<Turma> carregarPorNomeDoCurso(@Param("nomeCurso")String nomeCuro);

 //   List<Turma> carregarPorNomeDoProfessor(String nomeProfessor);


    @Query("SELECT t FROM Turma t WHERE t.professor.nome = :nomeProfessor  ")
    List<Turma> carregarPorNomeDoProfessor(@Param("nomeProfessor")String nomeProfessor);

  //  List<Turma> carregarPorNomeDoCliente(String nomeCliente);

    @Query("SELECT t FROM Turma t WHERE t.cliente.nome = :nomeCliente  ")
    List<Turma> carregarPorNomeDoCliente(@Param("nomeCliente")String nomeCliente);



    Turma findByNome(String nomeTurma);



}
