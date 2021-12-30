import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Curso } from '../entity/Curso';
import { CursoService } from '../Service/curso.service';
@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styles: []
})
export class CursoComponent implements OnInit {

  curso: Curso = new Curso();



  constructor(private router: Router, private service: CursoService) { }




  ngOnInit(): void {

  
  }

  addCurso(){
   this.service.addCurso(this.curso)
    .subscribe(data =>{
      alert('curso adicionado');
      this.router.navigate(["curso"]);
    })


  }

  getCurso() {
    this.router.navigate(["listar"]);
  }

}
