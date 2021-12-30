package com.sgt.controller.DTO;

import com.sgt.models.ListaChamada;
import com.sgt.models.Turma;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class ListaChamadaDTO {

    private Long id;



    private Turma turma;
    private LocalDateTime horario;


    public ListaChamadaDTO(ListaChamada listaChamada) {
        this.id = listaChamada.getId();
        this.turma = listaChamada.getTurma();
        this.horario = listaChamada.getHorario();
    }

    public static List<ListaChamadaDTO> converter(List<ListaChamada> chamadas){

        return chamadas.stream().map(ListaChamadaDTO::new).collect(Collectors.toList());

    }
}
