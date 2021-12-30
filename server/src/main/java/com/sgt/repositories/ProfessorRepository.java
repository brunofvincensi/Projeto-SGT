package com.sgt.repositories;
import com.sgt.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Professor findByNome(String nomeProfessor);
}
