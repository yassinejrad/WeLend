// @ts-ignore
import {insurance} from "entities";
export interface InsuranceTransaction {
  insuranceTransactionID:number;
  amount:number;
  insuranceTransactionStatus:String;
  description:String;
  insuranceTransactionDate:Date;
  insuranceID:number;
}
