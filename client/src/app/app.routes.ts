import { Routes } from '@angular/router';
import { HomeComponent } from './navegacao/home/home.component';
import { TurmaComponent } from './turma/turma.component';
import { CursoComponent } from './curso/curso.component';
import { AlunoComponent } from './aluno/aluno.component';
import { ProfessorComponent } from './professor/professor.component';
import { ClienteComponent } from './cliente/cliente.component';
import { DataBindingComponent } from './demos/data-binding/data-binding.component';
import { ListaProdutoComponent } from './produtos/lista-produto/lista-produto.component';
import { ListarTurmaComponent } from './turma/listarTurma/listarTurma.component';

export const rootRouterConfig: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    { path: 'home', component: HomeComponent},
    { path: 'turma', component: TurmaComponent },
    { path: 'curso', component: CursoComponent },
    { path: 'aluno', component: AlunoComponent },
    { path: 'professor', component: ProfessorComponent },
    { path: 'cliente', component: ClienteComponent },
    { path: 'feature-data-binding', component: DataBindingComponent },
    { path: 'produtos', component: ListaProdutoComponent },
    { path: 'produto-detalhe/:id', component: ListaProdutoComponent }
];