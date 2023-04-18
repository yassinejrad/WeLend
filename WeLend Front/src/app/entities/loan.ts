export interface Loan {
  LoanID:number;
  LoanNumber:number;
  LoanAmount:number;
  Status:String;
  InterestRate:number;
  durationInMonths:number;
  Collaterals:String;
  //List<LoanTransaction> RepaymentSchedule;
  loanStatus:String;
  /*@ManyToOne
  Account account;
  @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
  private Set<LoanTransaction> LoanTransactions;
  @OneToOne
  private LoanType loanType;*/
}
