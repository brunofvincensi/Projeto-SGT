import { Cliente } from "./Cliente";
import { Curso } from "./Curso";
import { Professor } from "./Professor";

export class Turma{
    horario?: String;
    periodo?: String;
    nome?: String;
    quantidadeAluno?: number;
    nomeCurso?: Curso;
    nomeProfessor?: Professor;
    nomeCliente?: Cliente;
}