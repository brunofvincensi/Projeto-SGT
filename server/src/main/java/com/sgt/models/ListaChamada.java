package com.sgt.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class ListaChamada {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Turma turma;


    private LocalDateTime horario = LocalDateTime.now();

  /*  @OneToMany(mappedBy = "lista")
    private List<Aluno> alunos = new ArrayList<>();
*/


  //  private List<Boolean> list = new ArrayList<Boolean>();


}
