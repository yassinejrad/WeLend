import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { InsuranceDetail } from 'src/app/entities/insuranceDetail';
import { InsuranceDetailService } from 'src/app/services/insuranceDetail/insurance-detail.service';

@Component({
  selector: 'app-insurance-detail',
  templateUrl: './insurance-detail.component.html',
  styleUrls: ['./insurance-detail.component.css']
})
export class InsuranceDetailComponent implements OnInit {
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
    private modalService: NgbModal ) { }

  ngOnInit(): void {
    this.insuranceDetail = {
      insuranceDetailID:0,
      insuredAmount:0,
      accidentDate:new Date(),
      accidentLocation:"",
      description:''
    };
    this.getInsurancesDetail();
  }
  public getInsurancesDetail(): void {
    this.InsuranceDetailService.getAllInsuranceDetails().subscribe((insuranceDetail: InsuranceDetail[]) => {
      this.insurancesDetail = insuranceDetail;
      for (let i = 0; i < this.insurancesDetail.length; i++) {
        console.log("Insurance Transaction Id: ", this.insurancesDetail[i].insuranceDetailID);
      }
    });
  }
  getInsuranceAccountByID(event:any){
    this.InsuranceDetailService.getAllInsuranceDetailByAccountID( event.target.value).subscribe((insuranceDetail: InsuranceDetail[]) => {
      console.log( event.target.value);
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
    this.InsuranceDetailService.deleteInsuranceDetail(insuranceID).subscribe(() => this.getInsurancesDetail())
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
    this.getInsurancesDetail;
  }
  
  
}
