import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import { AuthentificationRequest } from '../../entities/AuthentificationRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public login(authenticateRequest: AuthentificationRequest): Observable<string> {
    return this.http.post(`${this.apiUrl}/auth/authenticate`, authenticateRequest, { responseType: 'text' })
      .pipe(
        tap((token: string) => {
          localStorage.setItem('token', token);
          console.log('Token saved: ', token);
        })
      );
  }



  public logout(): void {
    localStorage.removeItem('token');
  }

  public isLoggedIn(): boolean {
    const token = localStorage.getItem('token');
    return token != null;
  }

  public getToken(): string | null {
    return localStorage.getItem('token');
  }
}
