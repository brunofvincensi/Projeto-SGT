package com.sgt.controller;


import com.sgt.controller.FORM.ProfessorFORM;
import com.sgt.controller.REFORM.ProfessorREFORM;
import com.sgt.controller.DTO.ProfessorDTO;
import com.sgt.models.Professor;
import com.sgt.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<ProfessorDTO> litarTudo() {
        List<Professor> professorList = professorRepository.findAll();
        return ProfessorDTO.converter(professorList);

    }


    @PostMapping
    public ResponseEntity<ProfessorDTO> gravar(@RequestBody @Valid ProfessorFORM professorFORM, UriComponentsBuilder uriComponentsBuilder) {

        Professor professor = professorFORM.converter(professorRepository);
        professorRepository.save(professor);


        URI uri = uriComponentsBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProfessorDTO(professor));


    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProfessorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProfessorREFORM form){

        Optional<Professor> professorPesquisado = professorRepository.findById(id);


        if(professorPesquisado.isPresent()){

            Professor professor = form.atualizar(id, professorRepository);
            return ResponseEntity.ok(new ProfessorDTO(professor));


        }

        return ResponseEntity.notFound().build();



    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){

        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){

            professorRepository.deleteById(id);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();


    }



}
