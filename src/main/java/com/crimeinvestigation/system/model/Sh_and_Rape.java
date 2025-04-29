package com.crimeinvestigation.system.model;

public class Sh_and_Rape extends Harassment{
    protected String relationToHarasser;
    protected String sexualHarassmentType;
    protected boolean rape;
    protected String rapeType;

    public Sh_and_Rape(String harassmentType,String relationToHarasser,String sexualHarassmentType,boolean rape,String rapeType){
        super(harassmentType);
        this.relationToHarasser=relationToHarasser;
        this.sexualHarassmentType=sexualHarassmentType;
        this.rape=rape;
        this.rapeType=rapeType;
    }
    public String getRelationToHarasser() {
        return relationToHarasser;
    }

    public void setRelationToHarasser(String relationToHarasser) {
        this.relationToHarasser = relationToHarasser;
    }

    public String getSexualHarassmentType() {
        return sexualHarassmentType;
    }

    public void setSexualHarassmentType(String sexualHarassmentType) {
        this.sexualHarassmentType = sexualHarassmentType;
    }

    public boolean isRape() {
        return rape;
    }

    public void setRape(boolean rape) {
        this.rape = rape;
    }

    public String getRapeType() {
        return rapeType;
    }

    public void setRapeType(String rapeType) {
        this.rapeType = rapeType;
    }

    @Override
    public String harassmentDetail(){
        return "Sexual Harrassment\n----------------\nSexual Harrassment Type";
    }
}
