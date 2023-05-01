import { Component, OnInit, Inject } from '@angular/core';
import { InsuranceService } from "../../services/insurance/insurance.service";
import { Insurance } from "../../entities/insurance";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Chart from 'chart.js/auto';


@Component({
  selector: 'app-insurance',
  templateUrl: './insurance.component.html',
  styleUrls: ['./insurance.component.css'],
  providers: [MatDialog]
})
export class InsuranceComponent implements OnInit {
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
  InterestByInsurance!:Map<String,number>;


  
  
  
  constructor(
    private InsuranceService: InsuranceService,
    private modalService: NgbModal
  ) { }
  
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
    this.createChart(this.calculateInterestByInsurance());
   
  }
  

  public getInsurances(): void {
    this.InsuranceService.getAllInsurances().subscribe((insurances: Insurance[]) => {
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
  public calculateInterestByInsurance(): Map<String,number> {
    this.InsuranceService.calculateInterestByinsuranceType().subscribe((InterestByInsurance: Map<String,number>) => {
      this.InterestByInsurance = InterestByInsurance;
    });
    return this.InterestByInsurance;
  }
  createChart(InterestByInsurance:Map<String,number>){

    this.chart = new Chart("MyChart", {
      type: 'pie', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: Array.from(InterestByInsurance.keys()),
         datasets: [{
    label: 'My First Dataset',
    data: Array.from(InterestByInsurance.values()),
    backgroundColor: [
      'red',
      'pink',
      'green',
      'yellow',
      'orange',
      'blue',			
    ],
    hoverOffset: 4
  }],
      },
      options: {
        aspectRatio:2.5
      }

    });
    }

  
  
  
  
}

