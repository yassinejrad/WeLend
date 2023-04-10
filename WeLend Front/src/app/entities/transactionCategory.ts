export interface TransactionCategory {
  transactionCategoryID:number;
  name:String;
  maxAmount:number;
  description:String;
  /*@OneToMany(cascade = CascadeType.ALL,mappedBy = "transactionCategory")
  private Set<Transaction> transactions;*/
}
