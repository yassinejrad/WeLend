import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Insurance} from "../../entities/insurance";
import {environment} from "../../../environments/environment";
import {AuthentificationService} from "../authentification/authentification.service";



@Injectable({
  providedIn: 'root'
})
export class InsuranceService {
 /* insuranceList:Insurance[]=[{
    insuranceID:0,
    insuranceDescription: 'Static Insurance',
    startDate: new Date('2022-01-01'),
    endDate: new Date('2022-12-31'),
    amount: 1000,
    intresetRate: 5,
    renewalCount: 0
  },
  {
    insuranceID:2,
    insuranceDescription: 'Static Insurance',
    startDate: new Date('2022-01-01'),
    endDate: new Date('2022-12-31'),
    amount: 1000,
    intresetRate: 5,
    renewalCount: 0
  },
  {
    insuranceID:3,
    insuranceDescription: 'Static Insurance',
    startDate: new Date('2022-01-01'),
    endDate: new Date('2022-12-31'),
    amount: 1000,
    intresetRate: 5,
    renewalCount: 0
  }];
  */
  private apiUrl =environment.apiBaseUrl;

  constructor(private http: HttpClient, private authService: AuthentificationService) {}

  public getAllInsurances(): Observable<Insurance[]>{
    return this.http.get<Insurance[]>(`${this.apiUrl}/insurance/getAll`);
  }
  public getAllInsurancesByAccountID(accountID:number): Observable<Insurance[]> {
    
    return this.http.get<Insurance[]>(`${this.apiUrl}/insurance/getAllInsurancesByAccountID/`+accountID);
  }
  public getInsuranceByID(insuranceID:number): Observable<Insurance> {
    return this.http.get<Insurance>(`${this.apiUrl}/insurance/getByID/`+insuranceID);
  }
  public updateInsurance(insurance: Insurance): Observable<Insurance> {
    return this.http.put<Insurance>(`${this.apiUrl}/insurance/update`, insurance);
  }
  public deleteInsurance(insuranceID: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/insurance/delete/`+ insuranceID);
  }
  public addInsurance(insurance: Insurance): Observable<Insurance> {
    return this.http.post<Insurance>(`${this.apiUrl}/insurance/add/`, insurance);
  }
  public addInsuranceAndTransaction(insurance: Insurance): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/insurance/addInsuranceAndTransaction/`, insurance);
  }
  public renewInsurance(insuranceID:number): Observable<void> {
    return this.http.get<void>(`${this.apiUrl}/insurance/renewInsurance/`+insuranceID);
  }
  public calculateInterestByYear(year:number): Observable<Map<String,number>> {
    return this.http.get<Map<String,number>>(`${this.apiUrl}/insurance/calculateInterestByYear/`+year);
  }
  public calculateInterestByInsurance(): Observable<Map<String,number>> {
    return this.http.get<Map<String,number>>(`${this.apiUrl}/insurance/calculateInterestByInsurance`);
  }
  public calculateInterestByinsuranceType(): Observable<Map<String,number>> {
    return this.http.get<Map<String,number>>(`${this.apiUrl}/insurance/calculateInterestByinsuranceType`);
  }


}
