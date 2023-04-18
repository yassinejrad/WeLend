export interface TypeLoan {
  LoanTypeID:number;
  LoanTypeName:String;
  duration:number;
  Value:number;

  LoanTerm:String;
/*
  @OneToOne
  private Loan loan;*/
}
