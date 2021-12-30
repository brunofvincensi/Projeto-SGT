import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Turma } from "src/app/entity/Turma";
import { TurmaService } from "src/app/Service/turma.service";

@Component({

  selector: 'app-listarTurma',
  templateUrl: './listarTurma.component.html',
  styleUrls: []

})

export class ListarTurmaComponent implements OnInit {



  listarTurma: Turma[];
  constructor(private service: TurmaService, private router: Router) { }

  ngOnInit(): void {
    this.service.getTurma()
      .subscribe(data => {
        this.listarTurma = data;
      });
  }



}





