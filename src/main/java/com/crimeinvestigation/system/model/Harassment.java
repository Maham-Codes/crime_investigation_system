package com.crimeinvestigation.system.model;

public abstract class Harassment extends Crime{
protected String harassmentType;

public Harassment(int CrimeID,boolean CCTVpresence,String weaponUsed,String injuryDetail,String motive,String harassmentType){
    super(CrimeID,CCTVpresence,weaponUsed,injuryDetail,motive);
    this.harassmentType=harassmentType;
}

    public Harassment(String harassmentType) {
    super();
    this.harassmentType=harassmentType;
    }

    public abstract String harassmentDetail();
}
