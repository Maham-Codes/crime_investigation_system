package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int crimeID;
    boolean CCTVpresence;

    String  weaponUsed;
    String injuryDetail;
    String motive ;


    public Crime(){}
 Crime(int crimeID,boolean CCTVpresence,String weaponUsed, String injuryDetail,String motive) {
     this.crimeID=crimeID;
     this.CCTVpresence=CCTVpresence;
     this.weaponUsed=weaponUsed;
     this.injuryDetail=injuryDetail;
     this.motive=motive;
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

}
