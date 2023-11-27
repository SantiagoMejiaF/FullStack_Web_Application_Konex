import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

/* The LocalityService class is responsible for making HTTP requests to retrieve locality data from a
server. */

export class LocalityService {

  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8081/api/localities';

/**
 * The function getAllLocalities sends an HTTP GET request to the base URL.
 * @returns The `getAllLocalities()` function is returning an HTTP GET request to the `baseUrl`.
 */
  getAllLocalities() {
    return this.http.get(`${this.baseUrl}`);
  }

/**
 * The function `getAllLocalitiesNames` makes an HTTP GET request to retrieve an array of locality
 * names.
 * @returns The getAllLocalitiesNames() function is returning an HTTP GET request to the specified URL,
 * which is expected to return an array of strings representing the names of localities.
 */
  getAllLocalitiesNames() {
    return this.http.get<string[]>(`${this.baseUrl}/names`);
  }

/**
 * The function `getLocalitiesByConcessionaireId` retrieves an array of locality names based on a given
 * concessionaire ID.
 * @param {number} concessionaireId - The `concessionaireId` parameter is a number that represents the
 * ID of a concessionaire.
 * @returns an HTTP GET request to the specified URL, which is expected to return an array of strings.
 */
  getLocalitiesByConcessionaireId(concessionaireId: number) {
    return this.http.get<string[]>(`${this.baseUrl}/names-by-concessionaire/${concessionaireId}`);
  }
}