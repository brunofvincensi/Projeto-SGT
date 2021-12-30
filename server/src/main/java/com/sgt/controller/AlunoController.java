package com.sgt.controller;

import com.sgt.controller.DTO.ClienteDTO;
import com.sgt.controller.FORM.AlunoFORM;
import com.sgt.controller.REFORM.AlunoREFORM;
import com.sgt.controller.DTO.AlunoDTO;
import com.sgt.models.Aluno;
import com.sgt.models.Cliente;
import com.sgt.repositories.AlunoRepository;
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
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    TurmaRepository turmaRepository;


    @GetMapping
    public List<AlunoDTO> litarTudo()
    {

        List<Aluno> alunoList = alunoRepository.findAll();
        return AlunoDTO.converter(alunoList);

    }


    @PostMapping
    public ResponseEntity<AlunoDTO> gravar(@RequestBody @Valid AlunoFORM alunoFORM, UriComponentsBuilder uriComponentsBuilder) {

        Aluno aluno = alunoFORM.converter(turmaRepository);
        alunoRepository.save(aluno);


        URI uri = uriComponentsBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new AlunoDTO(aluno));


    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AlunoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoREFORM form){

        Optional<Aluno> alunoPesquisado = alunoRepository.findById(id);


        if(alunoPesquisado.isPresent()){

            Aluno aluno = form.atualizar(id, alunoRepository);
            return ResponseEntity.ok(new AlunoDTO(aluno));


        }

        return ResponseEntity.notFound().build();



    }





    @DeleteMapping("/{nome}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String nome){

        Optional<Aluno> aluno = alunoRepository.findByNome(nome);
        if(aluno.isPresent()){

            alunoRepository.deleteByNome(nome);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();

    }


}
