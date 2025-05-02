package com.crimeinvestigation.system.model;

public class Crime {
    int crimeID;
    boolean CCTVpresence;
    String  weaponUsed;
     String injuryDetail;
     String motive ;
     String CrimeType;


 Crime(int crimeID,boolean CCTVpresence,String weaponUsed, String injuryDetail,String motive,String CrimeType) {
     this.crimeID=crimeID;
     this.CCTVpresence=CCTVpresence;
     this.weaponUsed=weaponUsed;
     this.injuryDetail=injuryDetail;
     this.motive=motive;
     this.CrimeType = CrimeType;
 }

    public int getcrimeID(){return crimeID;}
    public boolean getCCTVpresence(){return CCTVpresence;}
    public String weaponUsed(){return weaponUsed;}
    public String getInjuryDetail(){return injuryDetail;}
    public String getMotive() {return motive;}
    public void setCrimeID(int crimeID){}
    public void setCCTVpresence(boolean CCTVpresence){}
    public void setWeaponUsed(String weapponUsed){}
    public void setInjuryDetail(String injuryDetail){}
    public void setMotive(String motive) {this.motive=motive;}
    public String CrimeType(){return CrimeType;}
    public void setCrimeType(String CrimeType) {this.CrimeType=CrimeType;}

}
