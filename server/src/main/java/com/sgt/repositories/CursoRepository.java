package com.sgt.repositories;

import com.sgt.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

// para o post
    Curso findByNome(String nomeCurso);





}
