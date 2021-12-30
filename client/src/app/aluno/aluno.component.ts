import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Aluno } from '../entity/Aluno';
import { AlunoService } from '../Service/aluno.service';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styles: []
})
export class AlunoComponent implements OnInit {



  aluno: Aluno = new Aluno();





  constructor(private router: Router, private service: AlunoService) { }


  ngOnInit(): void {

  }




  addAluno() {

    if(this.aluno.nome.length < 5){

      alert('nome muito curto')

    } else

    this.service.addAluno(this.aluno)
      .subscribe(data => {
        alert('aluno adicionado');
        this.router.navigate(["aluno"])




      })




  }




}
