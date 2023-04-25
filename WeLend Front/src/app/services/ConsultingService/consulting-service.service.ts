import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Consultation} from "../../entities/Consultation"
import {environment} from "../../../environments/environment";
@Injectable({
  providedIn: 'root'
})
export class ConsultingServiceService {
  private apiUrl =environment.apiBaseUrl;
  constructor(private http: HttpClient) { }
  public getAllInsuranceDetails(): Observable<Consultation[]>{
    return this.http.get<Consultation[]>(`${this.apiUrl}/Consultation/all`);
  }
  public addConsultation(Consultation:Consultation): Observable<Consultation>{
    return this.http.post<Consultation>(`${this.apiUrl}/Consultation/add`,Consultation);
  }
  public updateConsultation(Consultation:Consultation): Observable<Consultation>{
    return this.http.put<Consultation>(`${this.apiUrl}/Consultation/update`,Consultation);
  }
  public deleteConsultation(ConsultationID:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/Consultation/delete`+ConsultationID);
  }
  public getConsultationById(ConsultationID:number): Observable<Consultation>{
    return this.http.get<Consultation>(`${this.apiUrl}/Consultation/getByID`+ConsultationID);
  }
  
  public ConsultationCalender(agentID:number) : Observable<Date>{
    return this.http.get<Date>(`${this.apiUrl}/Consultation/ConsultationCalender`+agentID);
    
}


}