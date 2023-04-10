import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {InsuranceDetail} from "../../entities/insuranceDetail";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class InsuranceDetailService {
  private apiUrl =environment.apiBaseUrl;
  constructor(private http: HttpClient) { }
  public getAllInsuranceDetails(): Observable<InsuranceDetail[]>{
    return this.http.get<InsuranceDetail[]>(`${this.apiUrl}/insuranceDetail/all`);
  }
  public addInsuranceDetail(insuranceDetail:InsuranceDetail): Observable<InsuranceDetail>{
    return this.http.post<InsuranceDetail>(`${this.apiUrl}/insuranceDetail/add`,insuranceDetail);
  }
  public updateInsuranceDetail(insuranceDetail:InsuranceDetail): Observable<InsuranceDetail>{
    return this.http.put<InsuranceDetail>(`${this.apiUrl}/insuranceDetail/update`,insuranceDetail);
  }
  public deleteInsuranceDetail(insuranceDetailID:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/insuranceDetail/delete`+insuranceDetailID);
  }
  public getInsuranceDetailById(insuranceDetailID:number): Observable<InsuranceDetail>{
    return this.http.get<InsuranceDetail>(`${this.apiUrl}/insuranceDetail/getByID`+insuranceDetailID);
  }
  public getInsuranceDetailByInsuranceID(insuranceID:number): Observable<InsuranceDetail[]>{
    return this.http.get<InsuranceDetail[]>(`${this.apiUrl}/insuranceDetail/getByInsuranceID`+insuranceID);
  }
  public getAverageAmountSpent(year: number): Observable<Map<number, number>> {
    return this.http.get<Map<number, number>>(`${this.apiUrl}/getAverageAmountSpent/`+year);
  }
  public getAllInsuranceDetailByAccountID(accountID:number): Observable<InsuranceDetail[]>{
    return this.http.get<InsuranceDetail[]>(`${this.apiUrl}/insuranceDetail/getAllInsuranceDetailByAccountID`+accountID);
  }

}
