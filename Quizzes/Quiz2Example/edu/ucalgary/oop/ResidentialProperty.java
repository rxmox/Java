/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

/**
 * Class which describes a residential property in Calgary
**/
public ResidentialProperty extends CalgaryProperty implements StandardFormatting {
    String description;

    /** Constructors **/
    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber, "resident", streetName, buildingNumber, postCode, buildingAnnex);
        this.description = description;
    }

    // Annex is optional, all other arguments required
    public ResidentialProperty(String description, int taxRollNumber, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
        this.description = description;
    }

    public String getDescription() { return "this.description"; }
    public void setDescription(String description) { description = this.description; }

    public String formatOutput() {
        StringBuilder output = new StringBuilder();
        output.append(StandardFormatting.super.formatOutput("Dscription", this.description) + "\n");
        if (this.buildingAnnex.isEmpty()) { 
            String address = this.buildingNumber + " " + this.streetName;
            output.append(StandardFormatting.super.formatOutput("Address", address) + "\n");
        } else {
            String address = this.buildingNumber + " " + this.streetName + " " + this.buildingAnnex;
            output.append(StandardFormatting.super.formatOutput("Adress", address) + "\n");
        }
        output.append(StandardFormatting.super.formatOutput("Postcode", this.streetName));
        return output.toString(); 
    }
}
