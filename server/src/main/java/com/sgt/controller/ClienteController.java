package com.sgt.controller;

import com.sgt.controller.FORM.ClienteFORM;
import com.sgt.controller.REFORM.ClienteREFORM;
import com.sgt.controller.DTO.ClienteDTO;
import com.sgt.models.Cliente;
import com.sgt.repositories.ClienteRepository;
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
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteRepository clienteRepository;




    @GetMapping
    public List<ClienteDTO> litarTudo()
    {
        List<Cliente> usuarioList = clienteRepository.findAll();
        return ClienteDTO.converter(usuarioList);

    }


    @PostMapping
    public ResponseEntity<ClienteDTO> gravar(@RequestBody ClienteFORM clienteFORM, UriComponentsBuilder uriComponentsBuilder){


        Cliente cliente = clienteFORM.converter(clienteRepository);
        clienteRepository.save(cliente);


        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDTO> atualizar(Long id, @RequestBody @Valid ClienteREFORM form){

        Optional<Cliente> clientePesquisado = clienteRepository.findById(id);


        if(clientePesquisado.isPresent()){

            Cliente cliente = form.atualizar(id, clienteRepository);
            return ResponseEntity.ok(new ClienteDTO(cliente));



        }

        return ResponseEntity.notFound().build();



    }


  /*  @DeleteMapping("/{nomeFantasia}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String nome){

        Optional<Cliente> cliente = clienteRepository.findByNome(nome);
        if(cliente.isPresent()){

            clienteRepository.deleteByNome(nome);
            return ResponseEntity.ok().build();


        }

        return ResponseEntity.notFound().build();

    }
*/


















}
