import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Curso } from "src/app/entity/Curso";
import { CursoService } from "src/app/Service/curso.service";

@Component({
    selector: 'app-listar',
    templateUrl: './listar.component.html',
    styleUrls: []
  })
  export class ListarComponent implements OnInit {
  
    listaCurso: Curso[];
    constructor(private service:CursoService, private router:Router) { }
  
    ngOnInit(): void {
      this.service.getCurso()
        .subscribe(data => {
          this.listaCurso = data;
        });
    }
  
  }