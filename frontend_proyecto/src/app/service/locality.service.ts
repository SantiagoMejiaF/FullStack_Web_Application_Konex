import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalityService {

  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8081/api/localities';

  getAllLocalities() {
    return this.http.get(`${this.baseUrl}`);
  }

  getAllLocalitiesNames() {
    return this.http.get<string[]>(`${this.baseUrl}/names`);
  }

  getLocalitiesByConcessionaireId(concessionaireId: number) {
    return this.http.get<string[]>(`${this.baseUrl}/names-by-concessionaire/${concessionaireId}`);
  }
}