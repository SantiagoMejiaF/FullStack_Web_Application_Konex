import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private baseUrl = 'http://localhost:8081/api/cities'

  constructor(private http: HttpClient) {}

  getAllCities() {
    return this.http.get(`${this.baseUrl}`);
  }

  getAllCitiesNames() {
    return this.http.get<string[]>(`${this.baseUrl}/names`);
  }

  getCityIdByName(cityName: string) {
    return this.http.get<number>(`${this.baseUrl}/id-by-name/${cityName}`);
  }
}