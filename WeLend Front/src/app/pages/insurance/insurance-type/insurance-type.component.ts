import { Component, OnInit } from '@angular/core';
import { InsuranceType } from 'src/app/entities/insuranceType';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceTypeService } from 'src/app/services/insuranceType/insurance-type.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { NumberMap } from 'src/app/entities/numberMap';

@Component({
  selector: 'app-insurance-type',
  templateUrl: './insurance-type.component.html',
  styleUrls: ['./insurance-type.component.css']
})

export class InsuranceTypeComponent implements OnInit {
  insurancesType!: InsuranceType[];
 
  closeResult! : string;
  p: number = 1; // variable for current page

  insuranceForm!: FormGroup;
  formBuilder!: FormBuilder;
  insuranceType!:InsuranceType;
  form : boolean = false;
  tableSize: number = 10;
  count : number = 0;

  constructor(private InsuranceTypeService: InsuranceTypeService,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.insuranceType = {
      insuranceTypeID: 0,
      name:'',
      description: '',
      value: 0,
      monthlyFees: 0
    };
    this.getInsurancesType();
  }
  public getInsurancesType(): void {
    this.InsuranceTypeService.getAllInsuranceType().subscribe((insuranceType: InsuranceType[]) => {
      this.insurancesType = insuranceType;
      console.log("List length : " , this.insurancesType.length)
      for (let i = 0; i < this.insurancesType.length; i++) {
        console.log("Insurance Type Id: ", this.insurancesType[i].insuranceTypeID);
      }
    });
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
    this.getInsurancesType;
  }
  deleteInsuranceType(insuranceTypeID : number){
    this.InsuranceTypeService.deleteInsuranceType(insuranceTypeID).subscribe(() => this.getInsurancesType())
  }
  
}
