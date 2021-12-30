import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from '../entity/Professor';
import { ProfessorService, } from '../Service/professor.service';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styles: []
})
export class ProfessorComponent implements OnInit {

  professor: Professor = new Professor();

  listaProfessor: Professor[];

  constructor(private router: Router, private service: ProfessorService) { }

  ngOnInit(): void {

    this.service.getProfessor()
    .subscribe(data => {
      this.listaProfessor = data
    })
  }

  addProfessor(){
    this.service.addProfessor(this.professor)
    .subscribe(data =>{
      alert('professor adicionado');
      this.router.navigate(["professor"]);
    })


  }

}
