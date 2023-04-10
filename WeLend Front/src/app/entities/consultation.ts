export interface Consultation {
  consultationID:number;
  date:Date;
  topic:String;
  location:String;
  consultationStatus:String;
  consultationLocation:String;
  /*@ManyToOne Client client;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "consultation")
  private Set<Agent> agents;*/
}
