import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../../entities/Client';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  readonly API_URL = 'http://localhost:8081/client';
  constructor(private http: HttpClient) {}
  getAll() {
    //return this.http.get<Events[]>('')
    return this.http.get(`${this.API_URL}/getall`);
  }
  add(client: Client) {
    return this.http.post(`${this.API_URL}/add/`, client);
  }
}
