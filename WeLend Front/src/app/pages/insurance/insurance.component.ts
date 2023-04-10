import { Component, OnInit } from '@angular/core';
import {InsuranceService} from "../../services/insurance/insurance.service";
import {Insurance} from "../../entities/insurance";


@Component({
  selector: 'app-insurance',
  templateUrl: './insurance.component.html',
  styleUrls: ['./insurance.component.css']
})
export class InsuranceComponent implements OnInit {
  public insurances!: Insurance[];

  constructor(private InsuranceService:InsuranceService) { }

  public getInsurances():void{
    this.InsuranceService.getAllInsurances().subscribe((insurances: Insurance[]) => {
      this.insurances = insurances;
      for (let i = 0; i < this.insurances.length; i++) {
        console.log("Insurance Id: ", this.insurances[i].insuranceID);
      }
    });
  }

  ngOnInit(): void {
    this.getInsurances();
  }

}
