package com.crimeinvestigation.system.model;

public abstract class Harassment extends Crime{
protected String harassmentType;

public Harassment(int CrimeID,boolean CCTVpresence,String weaponUsed,String injuryDetail,String motive,String harassmentType, String CrimeType){
    super(CrimeID,CCTVpresence,weaponUsed,injuryDetail,motive,CrimeType);
    this.harassmentType=harassmentType;
}

   // public Harassment(String harassmentType) {
  //  super();
 //   this.harassmentType=harassmentType;
 //   }

}
