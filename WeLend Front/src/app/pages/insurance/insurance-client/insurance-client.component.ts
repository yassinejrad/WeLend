import { Component, OnInit } from '@angular/core';
import { InsuranceService } from 'src/app/services/insurance/insurance.service';
import { Insurance } from 'src/app/entities/insurance';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-insurance-client',
  templateUrl: './insurance-client.component.html',
  styleUrls: ['./insurance-client.component.css']
})
export class InsuranceClientComponent implements OnInit {
  insurances!: Insurance[];
  
  closeResult! : string;
  p: number = 1; // variable for current page

  insuranceForm!: FormGroup;
  formBuilder!: FormBuilder;
  insurance!:Insurance;
  form : boolean = false;
  tableSize: number = 10;
  count : number = 0;
  chart: any;
  insuranceID!:number;


  constructor(private InsuranceService: InsuranceService,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.insurance = {
      insuranceID: 0,
      insuranceDescription: '',
      startDate: new Date(),
      endDate: new Date(),
      renewalCount: 0,
      intresetRate: 0,
      amount: 0,
    };
    this.getInsurances(); 
  }
  public getInsurances(): void {
    this.InsuranceService.getAllInsurancesByAccountID(1).subscribe((insurances: Insurance[]) => {
      this.insurances = insurances;
      for (let i = 0; i < this.insurances.length; i++) {
        console.log("Insurance Id: ", this.insurances[i].insuranceID);
      }
    });
  }
  
  addInsurance(){
    
    this.InsuranceService.addInsuranceAndTransaction(this.insurance).subscribe(() => {
      this.getInsurances();
      this.form = false;
    });
  }
  editInsurance(){
    this.InsuranceService.updateInsurance(this.insurance).subscribe(() => {
      this.getInsurances();
      this.form = false;
    });
  }
  deleteInsurance(insuranceID : number){
    this.InsuranceService.deleteInsurance(insuranceID).subscribe(() => this.getInsurances())
    this.closeResult = `Closed with: `;
  }
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  onTableDataChange(event: any) {
    console.log("this is the event "+event)
    this.p = event;
    this.getInsurances;
  }
  getInsuranceByID(event:any){
    this.InsuranceService.getInsuranceByID( event.target.value).subscribe((insurance: Insurance) => {
      this.insurances =[];
      console.log( event.target.value);
      this.insurances.push(insurance) ;
      console.log(insurance);
    });
  }
  renewInsurance(){
    console.log(this.insuranceID);
    this.InsuranceService.renewInsurance(this.insuranceID).subscribe(() => this.getInsurances())
  }
 

}
