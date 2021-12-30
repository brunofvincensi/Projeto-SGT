package com.sgt.controller;

import com.sgt.controller.DTO.ListaChamadaDTO;
import com.sgt.models.ListaChamada;
import com.sgt.repositories.ListaChamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista_de_chamada")
public class ListaChamadaController {

    @Autowired
    ListaChamadaRepository listaChamadaRepository;


    @GetMapping
    public List<ListaChamadaDTO> litarTudo() {
        List<ListaChamada> chamadaList = listaChamadaRepository.findAll();
        return ListaChamadaDTO.converter(chamadaList);

    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){

        Optional<ListaChamada> listaChamada = listaChamadaRepository.findById(id);
        if(listaChamada.isPresent()){

            listaChamadaRepository.deleteById(id);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();


    }

}
