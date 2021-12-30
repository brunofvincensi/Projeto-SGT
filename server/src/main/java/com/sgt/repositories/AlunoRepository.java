package com.sgt.repositories;

import com.sgt.models.Aluno;
import com.sgt.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


   

    Optional<Aluno> findByNome(String nome);

    void deleteByNome(String nome);

    Aluno getByNome(String nome);
}
