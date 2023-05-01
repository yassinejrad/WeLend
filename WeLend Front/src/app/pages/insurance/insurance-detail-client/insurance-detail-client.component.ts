import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { InsuranceDetail } from 'src/app/entities/insuranceDetail';
import { InsuranceDetailService } from 'src/app/services/insuranceDetail/insurance-detail.service';

@Component({
  selector: 'app-insurance-detail-client',
  templateUrl: './insurance-detail-client.component.html',
  styleUrls: ['./insurance-detail-client.component.css']
})
export class InsuranceDetailClientComponent implements OnInit {

  insurancesDetail!: InsuranceDetail[];
  
  closeResult! : string;
  p: number = 1; // variable for current page

  insuranceForm!: FormGroup;
  formBuilder!: FormBuilder;
  insuranceDetail!:InsuranceDetail;
  form : boolean = false;
  tableSize: number = 10;
  count : number = 0;
  constructor(private InsuranceDetailService:InsuranceDetailService,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.insuranceDetail = {
      insuranceDetailID:0,
      insuredAmount:0,
      accidentDate:new Date(),
      accidentLocation:"",
      description:''
    };
    this.getInsuranceAccountByID(1);
  }
  
  getInsuranceAccountByID(event:number){
    this.InsuranceDetailService.getAllInsuranceDetailByAccountID( event).subscribe((insuranceDetail: InsuranceDetail[]) => {
      console.log( event);
      this.insurancesDetail = insuranceDetail;
      for (let i = 0; i < this.insurancesDetail.length; i++) {
        console.log("Insurance Transaction Id: ", this.insurancesDetail[i].insuranceDetailID);
      }
    });
  }
  getInsuranceByInsuranceID(event:any){
    this.InsuranceDetailService.getInsuranceDetailByInsuranceID( event.target.value).subscribe((insuranceDetail: InsuranceDetail[]) => {
      console.log( event.target.value);
      this.insurancesDetail = insuranceDetail;
      for (let i = 0; i < this.insurancesDetail.length; i++) {
        console.log("Insurance Transaction Id: ", this.insurancesDetail[i].insuranceDetailID);
      }
    });
  }
  getInsuranceByID(event:any){
    this.InsuranceDetailService.getInsuranceDetailById( event.target.value).subscribe((insuranceDetail: InsuranceDetail) => {
      this.insurancesDetail =[];
      console.log( event.target.value);
      this.insurancesDetail.push(insuranceDetail) ;
      console.log(insuranceDetail);
    });
  }
  
  deleteInsuranceDetail(insuranceID : number){
    this.InsuranceDetailService.deleteInsuranceDetail(insuranceID).subscribe(() => this.getInsuranceAccountByID(1))
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

}
