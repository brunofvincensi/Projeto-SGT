import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Professor } from "../entity/Professor";

@Injectable({
    providedIn: 'root'
})

export class ProfessorService {
    constructor(private http: HttpClient) {}

    url = "http://localhost:8080/professor";

    addProfessor(professor: Professor) {

        return this.http.post<Professor>(this.url, professor)
    }

    getProfessor(){
        return this.http.get<Professor[]>(this.url);
    }

    
}