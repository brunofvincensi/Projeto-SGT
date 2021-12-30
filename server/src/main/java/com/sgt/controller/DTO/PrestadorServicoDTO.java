package com.sgt.controller.DTO;

import com.sgt.models.PrestadorServico;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@ToString
public class PrestadorServicoDTO {

    private String razaoSocial;
    private String nome;
    private String cnpj;
    private int numero;
    private String cep;
    private String cidade;

    public PrestadorServicoDTO(PrestadorServico prestadorServico) {
        this.razaoSocial = prestadorServico.getRazaoSocial();
        this.nome = prestadorServico.getNome();
        this.cnpj = prestadorServico.getCnpj();
        this.numero = prestadorServico.getNumero();
        this.cep = prestadorServico.getCep();
        this.cidade = prestadorServico.getCidade();
    }

    public static List<PrestadorServicoDTO> converter(List<PrestadorServico> prestadoresServico) {
        return prestadoresServico.stream().map(PrestadorServicoDTO::new).collect(Collectors.toList());
    }
}
