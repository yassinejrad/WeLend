import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {InsuranceType} from "../../entities/insuranceType";
import {environment} from "../../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class InsuranceTypeService {
  private apiUrl =environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getAllInsuranceType(): Observable<InsuranceType[]>{
    return this.http.get<InsuranceType[]>(`${this.apiUrl}/insuranceType/getAll`);
  }
  public addInsuranceType(insuranceType:InsuranceType): Observable<InsuranceType>{
    return this.http.post<InsuranceType>(`${this.apiUrl}/insuranceType/add`,insuranceType);
  }
  public updateInsuranceType(insuranceType:InsuranceType): Observable<InsuranceType>{
    return this.http.put<InsuranceType>(`${this.apiUrl}/insuranceType/update`,insuranceType);
  }
  public deleteInsuranceType(insuranceTypeID:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/insuranceType/delete/`+insuranceTypeID);
  }
  public getInsuranceTypeById(insuranceTypeID:number): Observable<InsuranceType>{
    return this.http.get<InsuranceType>(`${this.apiUrl}/insuranceType/getByID/`+insuranceTypeID);
  }

}
