/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

//package edu.ucalgary.oop;

import java.util.*;

/**
 * Class which describes a piece of property in Calgary, for use in multiple city applications.
**/
abstract class CalgaryProperty {
    // Recognized types of property zoning
    final String[] zoningTypes = {"COMMERCIAL", "RESIDENTIAL", "INDUSTRIAL",
        "AGRICULTURAL", "MIXED_USE" };

    // Basic information about property. Annex is optional.
    protected final int TAX_ROLL_NUMBER;
    protected String zoning;
    protected int buildingNumber;
    protected String buildingAnnex = "";
    protected String streetName;
    protected String postCode;

    /** Getters and Setters **/
    public int getTaxRollNumber() { return this.TAX_ROLL_NUMBER; }
    public String getZoning() { return zoning; }
    public int getBuildingNumber() { return this.buildingNumber; }
    public String getBuildingAnnex() { return this.buildingAnnex; }
    public String getStreetName() { return this.streetName; }
    public String getPostCode() { return this.postCode; }
    public void setBuildingNumber(int number) { this.buildingNumber = number; }
    public void setStreetName(String name) { this.streetName = name; }
    public void setBuildingAnnex(String id) { this.buildingAnnex = id; }

    // Setter with validity check - zones must match those in zoningTypes enum
    // Corrected setZoning to validate zoning types accurately
    public void setZoning(String zone) {
        zone = zone.toUpperCase();
        if (Arrays.asList(zoningTypes).contains(zone)) {
            this.zoning = zone;
        } else {
            throw new IllegalArgumentException("'" + zone + "' is not an existing zoning type. Zoning types are " + String.join(", ", zoningTypes));
        }
    }


    // Setter with validity check - postcodes must be 6 characters long
    public void setPostCode(String code) throws IllegalArgumentException {
        code = code.toUpperCase().replaceAll("[^A-Z0-9]", "");
        if (code.length() == 6) {
            this.postCode = code.substring(0, 3) + " " + code.substring(3);
        } else {
            throw new IllegalArgumentException("Postcode '" + code + "' is not correctly formatted.");
        }
    }
    

    /** Constructors **/
    // Example corrected constructor for CalgaryProperty
    public CalgaryProperty(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode, String buildingAnnex) {
        this.TAX_ROLL_NUMBER = taxRollNumber;
        setZoning(zoning); // Ensure this is a valid zoning type
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        setPostCode(postCode); // Format and set postcode correctly
        this.buildingAnnex = buildingAnnex;
    }

    // Annex is optional, all other arguments required
    public CalgaryProperty(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        createProperty(zoning, streetName, buildingNumber, postCode);
        this.TAX_ROLL_NUMBER = taxRollNumber;
    }


    /** Helpers **/
    private void createProperty(String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException{
        setPostCode(postCode);
        setZoning(zoning);
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        return;
    }
}
