import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../../services/authentification/authentification.service';
import { Router } from '@angular/router';
import { AuthentificationRequest } from '../../entities/AuthentificationRequest';
import { AuthService } from '../../services/user/auth.service';
import { TokenStorageService } from '../../services/user/token-storage.service';

@Component({
  selector: 'app-pages-login',
  templateUrl: './pages-login.component.html',
  styleUrls: ['./pages-login.component.css'],
})
export class PagesLoginComponent implements OnInit {
  email!: string;
  password!: string;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  loading = false;
  submitted = false;
  returnUrl!: string;
  isPageLoaded = false;

  constructor(
    private router: Router,
    public authService: AuthService,
    private tokenStorage: TokenStorageService
  ) {}
  onSubmit() {
    this.authService.login(this.email, this.password).subscribe(
      (data) => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.setUserInStorage(data);
        localStorage.removeItem('currentLayoutStyle');
        let returnUrl = '/';
        if (this.returnUrl) {
          returnUrl = this.returnUrl;
        }
        this.router.navigate([returnUrl]);
      },
      (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  setUserInStorage(res: any) {
    if (res.user) {
      localStorage.setItem('currentUser', JSON.stringify(res.user));
    } else {
      localStorage.setItem('currentUser', JSON.stringify(res));
    }
  }
  ngOnInit(): void {}
}
