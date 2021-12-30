package com.sgt.controller;

import com.sgt.controller.DTO.AlunoDTO;
import com.sgt.controller.DTO.ClienteDTO;
import com.sgt.controller.FORM.CursoFORM;
import com.sgt.controller.DTO.CursoDTO;
import com.sgt.controller.REFORM.AlunoREFORM;
import com.sgt.controller.REFORM.ClienteREFORM;
import com.sgt.controller.REFORM.CursoREFORM;
import com.sgt.models.Aluno;
import com.sgt.models.Cliente;
import com.sgt.models.Curso;
import com.sgt.repositories.CursoRepository;
import com.sgt.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ProfessorRepository professorRepository;


    @GetMapping
    public List<CursoDTO> litarTudo()
    {
        List<Curso> cursoList = cursoRepository.findAll();
        return CursoDTO.converter(cursoList);

    }

 /*   @PostMapping
    public ResponseEntity<CursoDTO> gravar(@RequestBody CursoFORM cursoFORM, UriComponentsBuilder uriComponentsBuilder) {

        Curso curso = cursoFORM.converter(cursoRepository);
        cursoRepository.save(curso);


        URI uri = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoDTO(curso));


    }
 */

    @PostMapping
    public ResponseEntity<Curso> insert(@RequestBody Curso obj){

        Curso curso = cursoRepository.findByNome(obj.getNome());
        if(curso != null){

            return ResponseEntity.unprocessableEntity().build();
        }


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);


    }






    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CursoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CursoREFORM form){

        Optional<Curso> cursoPesquisado = cursoRepository.findById(id);


        if(cursoPesquisado.isPresent()){

            Curso curso = form.atualizar(id, cursoRepository);
            return ResponseEntity.ok(new CursoDTO(curso));


        }

        return ResponseEntity.notFound().build();



    }





    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){

        Optional<Curso> curso = cursoRepository.findById(id);
        if(curso.isPresent()){

            cursoRepository.deleteById(id);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();


    }







}
