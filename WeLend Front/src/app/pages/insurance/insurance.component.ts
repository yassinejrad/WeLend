import { Component, OnInit, Inject } from '@angular/core';
import { InsuranceService } from "../../services/insurance/insurance.service";
import { Insurance } from "../../entities/insurance";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddInsuranceComponentComponent } from './add-insurance-component/add-insurance-component.component';
import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PaginatePipe } from 'ngx-pagination';


@Component({
  selector: 'app-insurance',
  templateUrl: './insurance.component.html',
  styleUrls: ['./insurance.component.css'],
  providers: [MatDialog]
})
export class InsuranceComponent implements OnInit {
  public insurances!: Insurance[];
  closeResult! : string;
  p: number = 1; // variable for current page


  constructor(
    private InsuranceService: InsuranceService,
    private dialog: MatDialog,
    private modalService: NgbModal
  ) { }
  
  insuranceForm!: FormGroup;
  formBuilder!: FormBuilder;
  insurance!:Insurance;
  
  

  ngOnInit(): void {
    this.insurances=this.InsuranceService.insuranceList;
    this.getInsurances();
    
    
  }

  public getInsurances(): void {
    this.InsuranceService.getAllInsurances().subscribe((insurances: Insurance[]) => {
      this.insurances = insurances;
      for (let i = 0; i < this.insurances.length; i++) {
        console.log("Insurance Id: ", this.insurances[i].insuranceID);
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
  
}
