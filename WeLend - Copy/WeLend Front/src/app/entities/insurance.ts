export interface Insurance{
  insuranceID:number;
  insuranceDescription:String;
  startDate:Date;
  endDate:Date;
  renewalCount:number;
  intresetRate:number;
  amount:number;

}
/*export class Insurance {
  insuranceID!:number;
  insuranceDescription!:String;
  startDate!:Date;
  endDate!:Date;
  renewalCount!:number;
  intresetRate!:number;
  amount!:number;


  constructor(insuranceID: number, insuranceDescription: String, startDate: Date, endDate: Date, renewalCount: number, intresetRate: number, amount: number) {
    this.insuranceID = insuranceID;
    this.insuranceDescription = insuranceDescription;
    this.startDate = startDate;
    this.endDate = endDate;
    this.renewalCount = renewalCount;
    this.intresetRate = intresetRate;
    this.amount = amount;
  }
}*/
