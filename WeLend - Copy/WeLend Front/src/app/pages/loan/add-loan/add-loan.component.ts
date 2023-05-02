import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute  } from '@angular/router';
import { LoanService } from 'src/app/services/loan.service';
import { NgForm } from '@angular/forms';
import { Loan } from 'src/app/entities/loan';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { LoanComponent } from '../loan.component';
@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  addLoanForm!: FormGroup;
  public isLoading: boolean = false;
  constructor(private loanService:LoanService, private formBuilder: FormBuilder, private dialogRef: MatDialogRef<AddLoanComponent> ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.isLoading = true;
    const newLoan: Loan = {
      loanID : 0 ,
      loanAmount: this.addLoanForm.value.loanAmount,
      loanNumber: this.addLoanForm.value.loanNumber,
      durationInMonths: this.addLoanForm.value.durationInMonths,
      interestRate: this.addLoanForm.value.interestRate,
      collaterals: this.addLoanForm.value.collaterals,
      loanStatus: this.addLoanForm.value.loanStatus,
    };
    this.loanService.addLoan(newLoan).subscribe(() => {
      this.isLoading = false;
      this.dialogRef.close("");
    });
  }
  onCancel(): void {
    this.dialogRef.close("");
  }

}
