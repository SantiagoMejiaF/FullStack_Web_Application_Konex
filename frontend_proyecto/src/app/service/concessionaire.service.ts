import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

/* The ConcessionaireService class is responsible for making HTTP requests to retrieve data related to
concessionaires. */

export class ConcessionaireService {

  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8081/api/concessionaires';

  getAllConcessionaires() {
    return this.http.get(`${this.baseUrl}`);
  }

  getAllConcessionairesNames() {
    return this.http.get<string[]>(`${this.baseUrl}/names`);
  }

  getAllConcessionairesByCity(cityId: number): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/names-by-city/${cityId}`);
  }

  getConcessionaireIdByName(concessionaireName: string) {
    return this.http.get<number>(`${this.baseUrl}/id-by-name/${concessionaireName}`);
  }
}