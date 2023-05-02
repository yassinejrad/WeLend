import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Loan } from '../entities/loan';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiBaseUrl = environment.apiBaseUrl ;

  constructor(private http: HttpClient) { }

  getAllLoans(): Observable<Loan[]> {
    return this.http.get<Loan[]>(`${this.apiBaseUrl}/loan/getAll`);
  }

  addLoan(loan: Loan): Observable<Loan> {
    const url = `${this.apiBaseUrl}/loan/add`;
    return this.http.post<Loan>(url, loan);
  }

  updateloan(loan: Loan): Observable<Loan> {
    const url = `${this.apiBaseUrl}/loan/update`;
    return this.http.put<Loan>(url, loan);
  }

  deleteLoan(id: number): Observable<Loan> {
    const url = `${this.apiBaseUrl}/loan/delete/${id}`;
    return this.http.delete<Loan>(url);
  }

  getByLoan(id: number): Observable<Loan> {
    const url = `${this.apiBaseUrl}/loan/getByID/${id}`;
    return this.http.get<Loan>(url);
  }
}
