package com.crimeinvestigation.system.model;

public class DrugTrafficking extends Crime implements CrimeType{
    protected String drugType;
    protected String quantity;
    protected String storageMethod;

    DrugTrafficking(int crimeID,boolean CCTVpresence,String weaponUsed, String injuryDetail,String motive,String drugType,String quantity,String storageMethod) {
        super(crimeID,CCTVpresence,weaponUsed,injuryDetail,motive);
        this.drugType = drugType;
        this.quantity = quantity;
        this.storageMethod = storageMethod;
    }

    DrugTrafficking(){
        super(0, false, null, null, null);
        drugType = null;
        quantity = null;
        storageMethod = null;
    }

    public String getdrugType(){return drugType;};
    public String getquantity(){return quantity;}
    public String getstorageMethod(){return storageMethod;}
    public void setdrugType(String drugType){this.drugType = drugType;}
    public void setquantity(String quantity){this.quantity = quantity;}
    public void setstorageMethod(String storageMethod){this.storageMethod = storageMethod;}

    @Override
    public void displayDetails() {
        System.out.println("Crime ID: " + crimeID);
        System.out.println("CCTV Presence: " + CCTVpresence);
        System.out.println("Weapon Used: " + weaponUsed);
        System.out.println("Injury Detail: " + injuryDetail);
        System.out.println("Motive: " + motive);
        System.out.println("Drug Type: "+drugType);
        System.out.println("Quantity: "+quantity);
        System.out.println("Storage Method: "+storageMethod);
    }
}
