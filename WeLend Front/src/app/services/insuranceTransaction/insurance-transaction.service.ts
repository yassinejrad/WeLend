import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Insurance} from "../../entities/insurance";
import {InsuranceTransaction} from "../../entities/insuranceTransaction";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class InsuranceTransactionService {

  private apiUrl =environment.apiBaseUrl;

  constructor(private http: HttpClient) {}
  public addInsuranceTransaction(insuranceTransaction:InsuranceTransaction): Observable<InsuranceTransaction>{
    return this.http.post<InsuranceTransaction>(`${this.apiUrl}/insurance/add`,insuranceTransaction);
  }
  public updateInsuranceTransaction(insuranceTransaction:InsuranceTransaction): Observable<InsuranceTransaction>{
    return this.http.put<InsuranceTransaction>(`${this.apiUrl}/insurance/update`,insuranceTransaction);
  }
  public deleteInsuranceTransaction(insuranceTransactionID:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/insurance/delete/`+insuranceTransactionID);
  }
  public getAllInsuranceTransaction(): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getAll`);
  }
  public getInsuranceTransactionById(insuranceTransactionID:number): Observable<InsuranceTransaction>{
    return this.http.get<InsuranceTransaction>(`${this.apiUrl}/insurance/getByID/`+insuranceTransactionID);
  }
  public getInsuranceTransactionByInsuranceId(insuranceID:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getByInsuranceID/`+insuranceID);
  }
  public checkAllUnpaidInsuranceTransactionByYear(insuranceID:number,year:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/checkAllUnpaidInsuranceTransactionByYear/`+insuranceID+'/'+year);
  }
  public getAllInsuranceTransactionPendingByInsurance(insuranceID:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getAllInsuranceTransactionPendingByInsurance/`+insuranceID);
  }
  public getAllInsuranceTransactionNotfullySetteledByInsurance(insuranceID:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getAllInsuranceTransactionNotfullySetteledByInsurance/`+insuranceID);
  }
  public getAllInsuranceTransactionSettledByInsurance(insuranceID:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getAllInsuranceTransactionSettledByInsurance/`+insuranceID);
  }
  public getAllInsuranceTransactionByAccountID(accountID:number): Observable<InsuranceTransaction[]>{
    return this.http.get<InsuranceTransaction[]>(`${this.apiUrl}/insurance/getAllInsuranceTransactionByAccountID/`+accountID);
  }

}
