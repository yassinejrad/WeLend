import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

import { Insurance } from 'src/app/entities/insurance';
import { InsuranceService } from 'src/app/services/insurance/insurance.service';
import { InsuranceComponent } from '../insurance.component';

@Component({
  selector: 'app-add-insurance-component',
  templateUrl: './add-insurance-component.component.html',
  styleUrls: ['./add-insurance-component.component.css']
})
export class AddInsuranceComponentComponent implements OnInit {
  addInsuranceForm!: FormGroup;
  public isLoading: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<AddInsuranceComponentComponent>,
    private insuranceService: InsuranceService,) { }

    ngOnInit(): void {
    }
  
    onSubmit(): void {
      this.isLoading = true;
      const newInsurance: Insurance = {
        insuranceID: 0,
        insuranceDescription: this.addInsuranceForm.value.insuranceDescription,
        startDate: this.addInsuranceForm.value.startDate,
        endDate: this.addInsuranceForm.value.endDate,
        amount: this.addInsuranceForm.value.amount,
        intresetRate: this.addInsuranceForm.value.intresetRate,
        renewalCount: this.addInsuranceForm.value.renewalCount,
      };
      this.insuranceService.addInsurance(newInsurance).subscribe(() => {
        this.isLoading = false;
        this.dialogRef.close("");
      });
    }
    onCancel(): void {
      this.dialogRef.close("");
    }

}
