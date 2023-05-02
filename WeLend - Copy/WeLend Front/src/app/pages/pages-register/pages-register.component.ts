import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../services/Client/client.service';
import { Client } from '../../entities/Client';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pages-register',
  templateUrl: './pages-register.component.html',
  styleUrls: ['./pages-register.component.css'],
})
export class PagesRegisterComponent implements OnInit {
  client = new Client();
  check!: boolean;
  constructor(private router: Router, private clientService: ClientService) {}

  ngOnInit(): void {
    this.check = false;
  }

  addClient() {
    console.log('----------------++++++++++' + this.client);
    this.clientService.add(this.client).subscribe(
      (data) => {
        console.log(true);
        console.log('----------------' + this.client);
        this.check = true;
        window.location.href = '/pages-login';
      },
      (err) => {
        console.log(err);
      }
    );
    if (this.check) {
      window.location.href = '/pages-login';
    }
  }
}
