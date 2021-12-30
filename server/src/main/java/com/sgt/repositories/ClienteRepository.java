package com.sgt.repositories;
import com.sgt.models.Cliente;
import com.sgt.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface ClienteRepository extends JpaRepository <Cliente, Long> {




    Cliente findByNome(String nomeCliente);


    void deleteByNome(String nome);
}
