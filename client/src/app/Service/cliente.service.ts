import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Cliente } from "../entity/Cliente";

@Injectable({
    providedIn: 'root'
})

export class ClienteService {
    constructor(private http: HttpClient) {}

    url = "http://localhost:8080/cliente";

    addCliente(cliente: Cliente) {

        return this.http.post<Cliente>(this.url, cliente)
    }

    getCliente() {
        return this.http.get<Cliente[]>(this.url);
      }

    
    
}