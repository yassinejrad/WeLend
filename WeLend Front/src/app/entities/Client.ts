export interface Client {
  clientID:number;
  UserName:String;
  birthDate:Date;
  phoneNum:number;
  adress:String;
  email:String;
  employement:String;
  income:number;
  expenses:number;
  pwd:String;
  score:number;
  statuslog:String;
  /*@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
  private Set<Reclaim> reclaims;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
  private Set<Account> accounts;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
  private  Set<Consultation> consultations;*/
}
