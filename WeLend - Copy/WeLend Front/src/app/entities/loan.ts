export class Loan {
  loanID?:number;
  loanNumber?:number;
  loanAmount?:number;
  //Status:String;
  interestRate?:number;
  durationInMonths?:number;
  collaterals?:String;
  //List<LoanTransaction> RepaymentSchedule;
  loanStatus?:String;
  /*@ManyToOne
  Account account;
  @OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
  private Set<LoanTransaction> LoanTransactions;
  @OneToOne
  private LoanType loanType;*/
}
