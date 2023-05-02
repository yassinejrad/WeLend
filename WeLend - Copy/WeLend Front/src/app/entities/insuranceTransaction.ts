// @ts-ignore
import {insurance} from "entities";
export interface InsuranceTransaction {
  insuranceTransactionID:number;
  amount:number;
  insuranceTransactionStatus:String;
  Description:String;
  insuranceTransactionDate:Date;
  insurance:insurance;
}
