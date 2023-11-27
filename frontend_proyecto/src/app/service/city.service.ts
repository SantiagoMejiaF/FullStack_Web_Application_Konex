import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

/* The CityService class is responsible for making HTTP requests to retrieve information about cities. */
export class CityService {

  private baseUrl = 'http://localhost:8081/api/cities'

  constructor(private http: HttpClient) {}

/**
 * The function `getAllCities` sends an HTTP GET request to the base URL.
 * @returns The `getAllCities()` function is returning an HTTP GET request to the `baseUrl`.
 */
  getAllCities() {
    return this.http.get(`${this.baseUrl}`);
  }

/**
 * The function `getAllCitiesNames` makes an HTTP GET request to retrieve an array of city names.
 * @returns The getAllCitiesNames() function is returning an HTTP GET request to the specified URL,
 * which is expected to return an array of strings representing city names.
 */
  getAllCitiesNames() {
    return this.http.get<string[]>(`${this.baseUrl}/names`);
  }

/**
 * The function `getCityIdByName` takes a city name as input and returns the corresponding city ID by
 * making an HTTP GET request.
 * @param {string} cityName - A string representing the name of a city.
 * @returns an HTTP GET request to the specified URL, which is expected to return a number representing
 * the city ID.
 */
  getCityIdByName(cityName: string) {
    return this.http.get<number>(`${this.baseUrl}/id-by-name/${cityName}`);
  }
}