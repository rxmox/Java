/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

//package edu.ucalgary.oop;

/**
 * Class which describes a residential property in Calgary
**/
public class ResidentialProperty extends CalgaryProperty implements StandardFormatting {
    String description;

    /** Constructors **/
    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode, buildingAnnex);
        this.description = description;
    }

    // Annex is optional, all other arguments required
    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
        this.description = description;
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description) {  this.description = description; }

    public String formatOutput() {
        StringBuilder output = new StringBuilder();
        output.append("Description:\t").append(this.description).append("\n");
        output.append("Address:\t").append(this.buildingNumber).append(" ").append(this.streetName);
        if (!this.buildingAnnex.isEmpty()) {
            output.append(" ").append(this.buildingAnnex);
        }
        output.append("\nPostcode:\t").append(this.postCode);
        return output.toString();
    }
    
}
