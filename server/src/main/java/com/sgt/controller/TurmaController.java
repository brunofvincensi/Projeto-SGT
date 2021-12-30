package com.sgt.controller;


import com.sgt.controller.DTO.DetalheTurmaDTO;
import com.sgt.controller.FORM.TurmaFORM;
import com.sgt.controller.DTO.TurmaDTO;
import com.sgt.controller.REFORM.TurmaREFORM;
import com.sgt.models.Aluno;
import com.sgt.models.Turma;
import com.sgt.repositories.ClienteRepository;
import com.sgt.repositories.CursoRepository;
import com.sgt.repositories.ProfessorRepository;
import com.sgt.repositories.TurmaRepository;
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
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<TurmaDTO> listarTopico(String nomeCurso, String nomeProfessor, String nomeCliente) {

        List<Turma> turmas;

        if (nomeCurso != null) {

            turmas = turmaRepository.carregarPorNomeDoCurso(nomeCurso);


        } else if (nomeProfessor != null){


            turmas = turmaRepository.carregarPorNomeDoProfessor(nomeProfessor);

        }

        else if (nomeCliente != null){

            turmas = turmaRepository.carregarPorNomeDoCliente(nomeCliente);

        }

        else


        turmas = turmaRepository.findAll();

        return TurmaDTO.converter(turmas);
    }

    @GetMapping ( "/{id}" )
    public ResponseEntity <DetalheTurmaDTO> redirecionamento (@PathVariable Long id) {
        Optional <Turma> turmaPesquisada = turmaRepository .findById (id) ;
        if (turmaPesquisada.isPresent ()) {
            return ResponseEntity. ok ( new DetalheTurmaDTO (turmaPesquisada.get())) ;
        }
        return ResponseEntity. notFound () .build () ;
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> gravar(@RequestBody @Valid TurmaFORM turmaFORM, UriComponentsBuilder uriComponentsBuilder) {

        Turma turma = turmaFORM.converter(cursoRepository, professorRepository, clienteRepository);
        turmaRepository.save(turma);

     /*  turma = turmaFORM.converter(professorRepository);
        turmaRepository.save(turma);


      */

        URI uri = uriComponentsBuilder.path("/turma/{id}").buildAndExpand(turma.getId()).toUri();

        return ResponseEntity.created(uri).body(new TurmaDTO(turma));



    }








    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TurmaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TurmaREFORM form){

        Optional<Turma> turmaPesquisada = turmaRepository.findById(id);


        if(turmaPesquisada.isPresent()){

            Turma turma = form.atualizar(id, turmaRepository);
            return ResponseEntity.ok(new TurmaDTO(turma));


        }

        return ResponseEntity.notFound().build();



    }









    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){

        Optional<Turma> turma = turmaRepository.findById(id);
        if(turma.isPresent()){

            turmaRepository.deleteById(id);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();


    }

}
