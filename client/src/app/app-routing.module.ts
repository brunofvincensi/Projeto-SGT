import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './curso/listar/listar.component';
import { Aluno } from './entity/Aluno';
import { Cliente } from './entity/Cliente';
import { Curso } from './entity/Curso';
import { Professor } from './entity/Professor';
import { Turma } from './entity/Turma';
import { ListarTurmaComponent } from './turma/listarTurma/listarTurma.component';


const routes: Routes = [

  { path: 'adicionar', component: Professor },
  { path: 'adicionar', component: Cliente },
  { path: 'adicionar', component: Aluno },
  { path: 'adicionar', component: Curso },
  {path: 'adicionar', component: Turma},
  {path: 'listar', component: ListarComponent},
  {path: 'listar', component: ListarTurmaComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
