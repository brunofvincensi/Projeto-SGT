package com.sgt.repositories;

import com.sgt.models.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Long> {



    Optional<PrestadorServico> findByNome(String nome);

    void deleteByNome(String nome);

 //   PrestadorServico getByRazaoSocial(String razaoSocial);
}
