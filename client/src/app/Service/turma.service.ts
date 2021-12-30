import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Turma } from "../entity/Turma";

@Injectable({
    providedIn: 'root'
})

export class TurmaService {

    constructor(private http: HttpClient) {}

    url = "http://localhost:8080/turma";

    addTurma(turma: Turma) {

        return this.http.post<Turma>(this.url, turma)
    }

    getTurma() {
        return this.http.get<Turma[]>(this.url);
      }


    
    
}