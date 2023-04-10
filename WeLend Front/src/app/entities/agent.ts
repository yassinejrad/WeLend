export interface Agent {
  agentID:number;
  UserName:String;
  birthDate:Date;
  phoneNum:number;
  adress:String;
  email:String;
  expenses:number;
  pwd:String;
  agentType:String;
  //@ManyToOne Consultation consultation;
}
