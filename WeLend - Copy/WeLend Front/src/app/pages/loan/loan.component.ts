import { Component, OnInit } from '@angular/core';
import { LoanService } from 'src/app/services/loan.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ModalDismissReasons,NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Loan } from 'src/app/entities/loan';
@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {
  loans!: Loan[];

  closeResult! : string;
  p: number = 1; // variable for current page

  loanForm!: FormGroup;
  formBuilder!: FormBuilder;
  newLoan!:Loan;
  form : boolean = false;
  tableSize: number = 10;
  count : number = 0;
 // chart: any;
  //InterestByInsurance!:Map<String,number>;





  constructor(
    private loanService: LoanService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.newLoan = {


        loanID :0,
        loanNumber :0,
        loanAmount :0,
        //Status:String;
        interestRate :0,
        durationInMonths :0,
        collaterals :'',
        //List<LoanTransaction> RepaymentSchedule;
        loanStatus :''
    };
    this.getLoans();
    //this.createChart(this.calculateInterestByInsurance());

  }


  public getLoans(): void {
    this.loanService.getAllLoans().subscribe((loans: Loan[]) => {
      this.loans = loans;
      for (let i = 0; i < this.loans.length; i++) {
        console.log("Insurance Id: ", this.loans[i].loanID);
      }
    });
  }

  addLoan(){

    this.loanService.addLoan(this.newLoan).subscribe(() => {
      this.getLoans();
      this.form = false;
    });
  }
  editLoan(){
    this.loanService.updateloan(this.newLoan).subscribe(() => {
      this.getLoans();
      this.form = false;
    });
  }
  deleteLoan(loanID : number){
    this.loanService.deleteLoan(loanID).subscribe(() => this.getLoans())
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
    this.getLoans();
  }


}
