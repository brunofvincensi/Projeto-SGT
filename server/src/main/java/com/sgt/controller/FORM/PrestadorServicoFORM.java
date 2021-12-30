package com.sgt.controller.FORM;

import com.sgt.models.PrestadorServico;
import com.sgt.repositories.PrestadorServicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestadorServicoFORM {
   // @NotNull
  //  @NotEmpty
    private String razaoSocial;

  //  @NotNull
  //  @NotEmpty
    private String nomeFantasia;

  //  @NotNull
 //  @NotEmpty
    private String cnpj;

  //  @NotNull
  //  @NotEmpty
    private int numero;

  //  @NotNull
  //  @NotEmpty
    private String cep;

  //  @NotNull
  //  @NotEmpty
    private String cidade;






    public PrestadorServico converter(PrestadorServicoRepository prestadorServicoRepository) {





        return new PrestadorServico(razaoSocial, nomeFantasia, cnpj, numero, cep, cidade);


    }
}
