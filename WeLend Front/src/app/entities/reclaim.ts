export interface Reclaim {
  reclaimID:number;
  ClientId:number;
  Description:String;
  AgentId:number;
  reclaimstatus:String;
  reclaimType:String;
  //@ManyToOne Client client;
}
