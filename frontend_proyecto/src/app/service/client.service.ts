import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../models/client';
import { ClientDTO } from '../models/clientDTO';

@Injectable({
  providedIn: 'root'
})

/* The ClientService class is responsible for making HTTP requests to interact with the client API
endpoints. */

export class ClientService {

  private baseUrl = 'http://localhost:8081/api/clients';

  constructor(private httpClient: HttpClient) {}

  getAllClients():Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}`);
  }

  createClient(client: ClientDTO): Observable<Object> {
    return this.httpClient.post<Client>(`${this.baseUrl}`, client);
  }

  updateClient(id: number, client: Client): Observable<Client> {
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

  searchClientsByLocality(locality: string): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}/search?locality=${locality}`);
  }

  searchClientsByCity(city: string): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}/search?city=${city}`);
  }

  searchClientsByConcessionaire(concessionaire: string): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}/search?concessionaire=${concessionaire}`);
  }

  searchClients(city: string, locality: string, concessionaire: string): Observable<Client[]> {
    return this.httpClient.get<Client[]>(`${this.baseUrl}/search?city=${city}&locality=${locality}&concessionaire=${concessionaire}`);
  }
}