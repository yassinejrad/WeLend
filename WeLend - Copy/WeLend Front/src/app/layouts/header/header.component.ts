import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT, Location } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../services/user/auth.service';
import { TokenStorageService } from '../../services/user/token-storage.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  public currentUser: any;
  constructor(
    @Inject(DOCUMENT) private document: Document,
    private router: Router,
    public authService: AuthService,
    private tokenStorage: TokenStorageService,
    private readonly location: Location
  ) {}

  ngOnInit(): void {
    console.log();
    if (localStorage.getItem('currentUser')) {
      this.currentUser = this.tokenStorage.getUser();
      console.log(this.currentUser);
    } else {
      if (
        this.location.path() != '/pages-login' &&
        this.location.path() != '/pages-register'
      ) {
        window.location.href = '/pages-login';
      }
    }
  }
  sidebarToggle() {
    //toggle sidebar function
    this.document.body.classList.toggle('toggle-sidebar');
  }
  logout() {
    if (localStorage.getItem('currentUser')) {
      this.authService.doLogout().then(
        (res) => {
          window.location.href = '/pages-login';
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
