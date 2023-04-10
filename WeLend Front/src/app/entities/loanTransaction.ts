export interface LoanTransaction {
  LoanTransactionID:number;
  LoanTransactionAmount:number;
  LoanTransactionDate:Date;
  Status:String;
  loanStatus:String;
  /*
  @ManyToOne
  Loan loan;*/
}
