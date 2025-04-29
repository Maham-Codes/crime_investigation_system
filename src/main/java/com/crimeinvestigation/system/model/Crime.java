package com.crimeinvestigation.system.model;

public class Crime {
    int crimeID;
    boolean CCTVpresence;
    String  weaponUsed;
     String injuryDetail;
     String motive ;


 Crime(int crimeID,boolean CCTVpresence,String weaponUsed, String injuryDetail,String motive) {
     this.crimeID=crimeID;
     this.CCTVpresence=CCTVpresence;
     this.weaponUsed=weaponUsed;
     this.injuryDetail=injuryDetail;
     this.motive=motive;
 }
 public void setcrimeID(int crimeID) { this.crimeID=crimeID; }
 public int getcrimeID() { return crimeID; }
    public void setCCTVpresence(boolean CCTVpresence) { this.CCTVpresence=CCTVpresence; }
    public boolean getCCTVpresence() { return CCTVpresence; }
    public void setweaponUsed(String weaponUsed) { this.weaponUsed=weaponUsed; }
    public String getweaponUsed() { return weaponUsed;}
    public void setInjuryDetail(String injuryDetail) {this.injuryDetail = injuryDetail;}
    public String getInjuryDetail() { return injuryDetail;}
    public void setMotive(String motive) { this.motive=motive; }
    public String getMotive() { return motive;}
}
