import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Curso } from "../entity/Curso";

@Injectable({
    providedIn: 'root'
})

export class CursoService {
    constructor(private http: HttpClient) {}

    url = "http://localhost:8080/curso";

    addCurso(curso: Curso) {

        return this.http.post<Curso>(this.url, curso)
    }

    getCurso() {
        return this.http.get<Curso[]>(this.url);
      }

    
}