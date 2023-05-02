export interface Account {
  accountID:number;
  accountType:String;
  statusAccount:String;
  openDate:Date;
  credit:number ;
 /* @OneToMany(cascade=CascadeType.ALL,mappedBy = "account")//esm lattribut moush lclass
  private Set<Transaction> transactions;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
  private Set<insurance> insurances;
  @ManyToOne Client client;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
  private Set<Notification> notifications;*/
}
