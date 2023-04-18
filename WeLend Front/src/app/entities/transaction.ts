export interface Transaction {
  transactionID:number;
  reciever:number;
  transactionType:String;
  transactionStatus:String;
  transactionMethod:String;
  transactionPurpose:String;
  exchangeRate:number;
  amount:number;
  currency:String;
  fees:number;
  transactionDate:Date;
  /*@ManyToOne transactionCategory transactionCategory;
  @ManyToOne Account account;*/

}
