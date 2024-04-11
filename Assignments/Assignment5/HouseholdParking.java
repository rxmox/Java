/**
 * @author Omar Ahmed
 * @version 1.5
 * @since 1.0
 */
package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.*;

public class HouseholdParking extends CalgaryProperty {
    // Each residental property is allowed one street parking permit
    private String residentLicence;
    private VisitorParking visitorParking;

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode,buildingAnnex);
        this.visitorParking = new VisitorParking();
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode);
        this.visitorParking = new VisitorParking();
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most recent
     * Ignore if the licence is already stored
     * @param licence - The licence plate to be added
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta licence
    */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        this.residentLicence = Parking.standardizeAndValidateLicence(licence);
    }

    /*
     * Remove all listed licences
     * @return whether the operation succeeded or not
    */
    public boolean removeResidentLicence() {
        this.residentLicence = "";
        return true;
    }

    /*
     * Remove a specific listed licence 
     * @param licence - the licence to be removed
     * @return whether the operation succeeded or not
    */
    public boolean removeResidentLicence(String license) {
        // Standardize the licence name. If it is invalid, it can't exist so return false.
        try {
            license = Parking.standardizeAndValidateLicence(license);
        }
        catch (Exception e) {
            return false;
        }

        if (residentLicence == license) {
            this.residentLicence = "";
            return true;
        }

        // Couldn't find entry
        return false;
    }
        
    /*
     * Get all the licences stored for the resident
     * @return An array containing the resident's licences
    */
    public String getResidentLicence() {
        return this.residentLicence;
    }

    public VisitorParking getVisitors(){
        return this.visitorParking;
    }

    public void addVisitorReservation(String license){
        this.visitorParking.addVisitorReservation(license);
    }

    public void addVisitorReservation(String license, LocalDate date){
        this.visitorParking.addVisitorReservation(license, date);
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return this.visitorParking.getLicencesRegisteredForDate();
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        return this.visitorParking.getLicencesRegisteredForDate(date);
    }

    public boolean licenceIsRegisteredForDate(String license) {
        return this.visitorParking.licenceIsRegisteredForDate(license);
    }

    public boolean licenceIsRegisteredForDate(String license, LocalDate date) {
        return this.visitorParking.licenceIsRegisteredForDate(license, date);
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String license){
        return this.visitorParking.getAllDaysLicenceIsRegistered(license);
    }
    
    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String license){
        return this.visitorParking.getStartDaysLicenceIsRegistered(license);
    }

}

