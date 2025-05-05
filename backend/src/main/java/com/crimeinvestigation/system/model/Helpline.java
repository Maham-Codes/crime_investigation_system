package com.crimeinvestigation.system.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
    public class Helpline {
    @Id
        private int HelplineID;
        private String region,helplineNo,helplineType;

        Helpline(int HelplineID , String helplineType , String region , String helplineNo){
            this.HelplineID = HelplineID;
            this.helplineType = helplineType;
            this.region = region;
            this.helplineNo = helplineNo;
        }
    public Helpline() {}

        public int getHelplineID() {
            return HelplineID;
        }

        public String getRegion() {
            return region;
        }

        public String getHelplineNo() {
            return helplineNo;
        }

        public String getHelplineType() {
            return helplineType;
        }

        public void DisplayInfo() {
            System.out.println("HelplineID: "+HelplineID);
            System.out.println("Type: "+helplineType);
            System.out.println("Area: "+region);
            System.out.println("Helpline Number: "+helplineNo);
        }

}
