package com.sgt.controller.REFORM;

import com.sgt.models.PrestadorServico;
import com.sgt.repositories.PrestadorServicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestadorServicoREFORM {

    private String razaoSocial;
    private String nomeFantasia;
    private int numero;
    private String cep;
    private String cidade;


   /* public PrestadorServico atualizar(Long id, PrestadorServicoRepository prestadorServicoRepository) {


        PrestadorServico prestadorServico = prestadorServicoRepository.getById(id);

        prestadorServico.setRazaoSocial(this.razaoSocial);
        prestadorServico.setNomeFantasia(this.nomeFantasia);
        prestadorServico.setNumero(this.numero);
        prestadorServico.setCep(this.cep);
        prestadorServico.setCidade(this.cidade);

        return prestadorServico;

    }
*/
    public PrestadorServico atualizar(Long id, PrestadorServicoRepository prestadorServicoRepository){

        PrestadorServico prestadorServico = prestadorServicoRepository.getById(id);

        prestadorServico.setRazaoSocial(this.razaoSocial);


        return prestadorServico;

    }
}
