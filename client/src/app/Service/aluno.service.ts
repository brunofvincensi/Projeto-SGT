import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Aluno } from "../entity/Aluno";

@Injectable({
    providedIn: 'root'
})

export class AlunoService {
    constructor(private http: HttpClient) {}

    url = "http://localhost:8080/aluno";

    addAluno(aluno: Aluno) {

        return this.http.post<Aluno>(this.url, aluno)
    }



    
    
}