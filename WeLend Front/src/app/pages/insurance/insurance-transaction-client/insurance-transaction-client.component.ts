import { Component, OnInit } from '@angular/core';
import { InsuranceTransaction } from 'src/app/entities/insuranceTransaction';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { InsuranceTransactionService } from 'src/app/services/insuranceTransaction/insurance-transaction.service';

@Component({
  selector: 'app-insurance-transaction-client',
  templateUrl: './insurance-transaction-client.component.html',
  styleUrls: ['./insurance-transaction-client.component.css']
})
export class InsuranceTransactionClientComponent implements OnInit {
  
  insurancesTransaction!: InsuranceTransaction[];
  
  closeResult! : string;
  p: number = 1; // variable for current page

  insuranceForm!: FormGroup;
  formBuilder!: FormBuilder;
  insuranceTransaction!:InsuranceTransaction;
  form : boolean = false;
  tableSize: number = 10;
  count : number = 0;

  constructor(private InsuranceTransactionService: InsuranceTransactionService,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getInsuranceAccountByID(1);
  }
  
  
  
  deleteInsuranceTransaction(insuranceID : number){
    this.InsuranceTransactionService.deleteInsuranceTransaction(insuranceID).subscribe(() => this.getInsuranceAccountByID(1))
    this.ngOnInit;
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
    this.getInsuranceAccountByID(1);
  }
  getInsuranceAccountByID(event:number){
    this.InsuranceTransactionService.getAllInsuranceTransactionByAccountID( event).subscribe((insurancesTransaction: InsuranceTransaction[]) => {
      console.log( event);
      this.insurancesTransaction = insurancesTransaction;
      for (let i = 0; i < this.insurancesTransaction.length; i++) {
        console.log("Insurance Transaction Id: ", this.insurancesTransaction[i].insuranceTransactionID);
      }
    });
  }
  getInsuranceByInsuranceID(event:any){
    this.InsuranceTransactionService.getInsuranceTransactionByInsuranceId( event.target.value).subscribe((insurancesTransaction: InsuranceTransaction[]) => {
      console.log( event.target.value);
      this.insurancesTransaction = insurancesTransaction;
      for (let i = 0; i < this.insurancesTransaction.length; i++) {
        console.log("Insurance Transaction Id: ", this.insurancesTransaction[i].insuranceTransactionID);
      }
    });
  }
  getInsuranceByID(event:any){
    this.InsuranceTransactionService.getInsuranceTransactionById( event.target.value).subscribe((insuranceTransaction: InsuranceTransaction) => {
      this.insurancesTransaction =[];
      console.log( event.target.value);
      this.insurancesTransaction.push(insuranceTransaction) ;
      console.log(insuranceTransaction);
    });
  }
  

}
