import { Component, OnInit, ElementRef } from '@angular/core';
import { NumberMap } from 'src/app/entities/numberMap';
import { InsuranceService } from 'src/app/services/insurance/insurance.service';
import Chart from 'chart.js/auto';
import { InsuranceDetailService } from 'src/app/services/insuranceDetail/insurance-detail.service';
import { NumberNumberMap } from 'src/app/entities/numberNumberMap';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  myNumber!:number[];
  myNumber2!:number[];
  myString!:String[];
  numberMap!:NumberMap;
  numberNumberMap!:NumberNumberMap;
  chart: any;
  constructor(private elementRef: ElementRef, private InsuranceService:InsuranceService,private InsuranceDetailService:InsuranceDetailService) { }

  ngOnInit(): void {

    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "../assets/js/main.js";
    this.elementRef.nativeElement.appendChild(s);
    this.calculateInterestByInsurance();
    this.calculateInterestByType();
    this.getAverageAmountSpent();
  }
   public calculateInterestByInsurance() {
    this.InsuranceService.calculateInterestByInsurance().subscribe((numberMap: NumberMap) => {
      this.numberMap = numberMap;
      this.myNumber = Object.values(this.numberMap);
      this.myString=Object.keys(this.numberMap);
      for (let i = 0; i < this.myNumber.length; i++) {
        console.log("Insurance Id: ", this.myNumber[i]);
      }
      this.chart = new Chart("Interest By Insurance", {
        type: 'doughnut', //this denotes tha type of chart
  
        data: {// values on X-Axis
          labels: this.myString,
           datasets: [{
      label: 'Interest',
      data: this.myNumber,
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
      
    });
    
  }
  public getAverageAmountSpent() {
    this.InsuranceDetailService.getAverageAmountSpent(2023).subscribe((numberMap: NumberNumberMap) => {
      this.numberNumberMap = numberMap;
      this.myNumber = Object.values(this.numberNumberMap);
      this.myString=Object.keys(this.numberNumberMap);
      console.log("keys: ", this.myNumber[1]);
      for (let i = 0; i < this.myNumber.length; i++) {
        console.log("keys2: ", this.myNumber[i]);
      }
      this.chart = new Chart("AverageAmountSpent", {
        type: 'bar', //this denotes tha type of chart
  
        data: {// values on X-Axis
          labels: ['JAN','FEB','MAR','APR','MAY','JUN','JUL','AUG','SEP','OCT','NOV','DEC'], 
           datasets: [
            {
              label: "Average Amount Spent",
              data: this.myNumber,
              backgroundColor: 'limegreen'
            } 
          ]
        },
        options: {
          aspectRatio:2.5
        }
        
      });
      
      
    });
    
  }
  public calculateInterestByType() {
    this.InsuranceService.calculateInterestByinsuranceType().subscribe((numberMap: NumberMap) => {
      this.numberMap = numberMap;
      this.myNumber = Object.values(this.numberMap);
      this.myString=Object.keys(this.numberMap);
      for (let i = 0; i < this.myNumber.length; i++) {
        console.log("Insurance Id: ", this.myNumber[i]);
      }
      this.chart = new Chart("InterestByinsuranceTypeChart", {
        type: 'pie', //this denotes tha type of chart
  
        data: {// values on X-Axis
          labels: this.myString,
           datasets: [{
      label: 'Interest',
      data: this.myNumber,
      backgroundColor: [
        
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
      
    });
    
  }
}
