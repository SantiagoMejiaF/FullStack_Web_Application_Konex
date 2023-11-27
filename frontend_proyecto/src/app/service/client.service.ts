import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../models/client';

@Injectable({
  providedIn: 'root'
})

export class ClientService {

  private baseUrl = 'http://localhost:8081/api/clients';

  constructor(private httpClient: HttpClient) {}

  getAllClients():Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}`);
  }

  createClient(client: Client): Observable<Object> {
    return this.httpClient.post<Client>(`${this.baseUrl}`, client);
  }

  editClient(id: number, client: Client): Observable<Client> {
    return this.httpClient.put<Client>(`${this.baseUrl}/${id}`, client);
  }

  deleteClient(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  getClientById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(`${this.baseUrl}/${id}`);
  }

  getAllClientsNames(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}/names`);
  }
}