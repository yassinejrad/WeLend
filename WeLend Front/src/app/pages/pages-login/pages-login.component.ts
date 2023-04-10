import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../../services/authentification/authentification.service";
import {Router} from "@angular/router";
import {AuthentificationRequest} from "../../entities/AuthentificationRequest";

@Component({
  selector: 'app-pages-login',
  templateUrl: './pages-login.component.html',
  styleUrls: ['./pages-login.component.css']
})
export class PagesLoginComponent implements OnInit {

  email!: string;
  password!: string;
  private authRequest!: AuthentificationRequest;

  constructor(private authService: AuthentificationService, private router: Router) { }
  onSubmit(){
    this.authRequest= {
      email: this.email,
      password: this.password
    };
    console.log('Submitting form...'+this.authRequest.email+this.authRequest.password);
    this.authService.login(this.authRequest).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
  ngOnInit(): void {
  }

}
