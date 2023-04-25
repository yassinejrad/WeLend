import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../../entities/Client";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {
  private apiUrl =environment.apiBaseUrl;
  constructor(private http: HttpClient) { }
  public getAllInsuranceDetails(): Observable<Client[]>{
    return this.http.get<Client[]>(`${this.apiUrl}/Client/all`);
  }
  public addClient(Client:Client): Observable<Client>{
    return this.http.post<Client>(`${this.apiUrl}/Client/add`,Client);
  }
  public updateClient(Client:Client): Observable<Client>{
    return this.http.put<Client>(`${this.apiUrl}/Client/update`,Client);
  }
  public deleteClient(ClientID:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/Client/delete`+ClientID);
  }
  public getClientById(ClientID:number): Observable<Client>{
    return this.http.get<Client>(`${this.apiUrl}/Client/getByID`+ClientID);
  }
  public  NotificationBeforeConsultation( clientID :number): Observable<Client>{
    return this.http.get<Client>(`${this.apiUrl}/Client/NotificationBeforeConsultation`+clientID);
  }
  public  NotificationAfterConsultation( clientID :number): Observable<Client>{
    return this.http.get<Client>(`${this.apiUrl}/Client/NotificationAfterConsultation`+clientID);
  }
  public  BankScoring( clientID :number): Observable<string>{
    return this.http.get<string>(`${this.apiUrl}/Client/BankScorring`+clientID);
  }




}
