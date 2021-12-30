package com.sgt.controller;


import com.sgt.controller.FORM.PrestadorServicoFORM;
import com.sgt.controller.DTO.PrestadorServicoDTO;
import com.sgt.controller.REFORM.PrestadorServicoREFORM;
import com.sgt.models.PrestadorServico;
import com.sgt.repositories.PrestadorServicoRepository;
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
@RequestMapping("/prestador_servico")
public class PrestadorServicoController {


    @Autowired
    PrestadorServicoRepository prestadorServicoRepository;



    @GetMapping
    public List<PrestadorServicoDTO> litarTudo() {
        List<PrestadorServico> prestadorServicoList = prestadorServicoRepository.findAll();
        return PrestadorServicoDTO.converter(prestadorServicoList);

    }

    @PostMapping
    public ResponseEntity<PrestadorServicoDTO> gravar(@RequestBody  PrestadorServicoFORM prestadorServicoFORM, UriComponentsBuilder uriComponentsBuilder){


        PrestadorServico prestadorServico = prestadorServicoFORM.converter(prestadorServicoRepository);
        prestadorServicoRepository.save(prestadorServico);


        URI uri = uriComponentsBuilder.path("/prestador_servico/{id}").buildAndExpand(prestadorServico.getId()).toUri();

        return ResponseEntity.created(uri).body(new PrestadorServicoDTO(prestadorServico));

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PrestadorServicoDTO> atualizar(@PathVariable  Long id, @RequestBody @Valid PrestadorServicoREFORM form){

        Optional<PrestadorServico> prestadorServicoPesquisado = prestadorServicoRepository.findById(id);


        if(prestadorServicoPesquisado.isPresent()){

            PrestadorServico prestadorServico = form.atualizar(id, prestadorServicoRepository);
            return ResponseEntity.ok(new PrestadorServicoDTO(prestadorServico));


        }

        return ResponseEntity.notFound().build();



    }







    @DeleteMapping("/{nomeFantasia}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String nome){

        Optional<PrestadorServico> prestadorServico = prestadorServicoRepository.findByNome(nome);
        if(prestadorServico.isPresent()){

            prestadorServicoRepository.deleteByNome(nome);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();


    }




}
