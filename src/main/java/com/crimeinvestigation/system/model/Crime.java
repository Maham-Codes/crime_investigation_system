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
 Crime(){

 }
}
