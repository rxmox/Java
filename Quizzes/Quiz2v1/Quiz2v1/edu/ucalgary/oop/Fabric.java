/*
 * Version: student code
*/

//package edu.ucalgary.oop;

import java.util.Arrays;

// Fixed: changed name of class to match the name of the file
public class Fabric {
    // Constant string array of fabric types
    // Fixed: removed Pleather from list and added BAMBOO
    private static final String[] FABRIC_TYPES = {"SILK", "WOOL", "COTTON", "POLYESTER", "LEATHER", "BAMBOO"};

    // String array to store fabric types
    private String[] fabricTypes = new String[3];

    /** Constructors **/

    /*
     * Constructor that takes an array of strings and calls setFabricTypes
     * @param fabricTypes - the array of fabric types to set
     * @throws IllegalArgumentException if any fabric type is not among the available fabric types
    */
    public Fabric(String[] fabricTypes) throws IllegalArgumentException {
        setFabricTypes(fabricTypes);
    }

    /*
     * Constructor that takes a single string and calls addFabricType
     * @param fabricType - the fabric type to add
     * @throws IllegalArgumentException if the fabric type is not among the available fabric types
    */
    // Fixed: Throws IllegalArgumentException instead of IllegalStateException
    public Fabric(String fabricType) throws IllegalArgumentException {
        if (!addFabricType(fabricType)) {
            throw new IllegalArgumentException("Invalid fabric type: " + fabricType);
        }
    }

    /** Getter and Setter **/

    /*
     * Getter for fabricTypes array
     * @return all fabric types
    */
    public String[] getFabricTypes() {
        return fabricTypes;
    }

    /*
     * Setter for fabricTypes array
     * Validates the argument against available fabric types and normalizes to lowercase
     * @param fabricTypes - the array of fabric types to set
     * @throws IllegalArgumentException if any fabric type is not among the available fabric types
    */
    
    public void setFabricTypes(String[] fabricTypes) throws IllegalArgumentException {
        for (int i = 0; i < fabricTypes.length; i++) {
            if (!isValidFabricType(fabricTypes[i])) {
                // Fixed: instead of returning it throws an exception
                throw new IllegalArgumentException("Invalid fabric type: " + fabricTypes[i]);
            }
            this.fabricTypes[i] = fabricTypes[i].toLowerCase();
        }
    }

    /** Other Methods **/

    /*
     * Method to add a fabric type to the fabricTypes array
     * @param fabricType - the fabric type to add
     * @return true if the fabric type could be added, false if the array was full or the fabric type is invalid
     * @throws IllegalArgumentException if the fabric type is not among the available fabric types
    */
    public boolean addFabricType(String fabricType) throws IllegalArgumentException {
        if (Arrays.asList(fabricTypes).contains(null) && isValidFabricType(fabricType)) {
            for (int i = 0; i < fabricTypes.length; i++) {
                if (fabricTypes[i] == null) {
                    fabricTypes[i] = fabricType.toLowerCase();
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Method to remove a fabric type from the fabricTypes array
     * @param fabricType - the fabric type to remove
     * @return true if the fabric type could be removed, false if it was not in the array
     * @throws IllegalArgumentException if the fabric type is not among the available fabric types
    */
    public boolean removeFabricType(String fabricType) throws IllegalArgumentException {
        for (int i = 0; i < fabricTypes.length; i++) {
            if (fabricTypes[i] != null && fabricTypes[i].equalsIgnoreCase(fabricType)) {
                fabricTypes[i] = null;
                shiftArrayElements();
                return true;
            }
        }
        return false;
    }

    /*
     * Helper method to shift array elements so that there are no null values in the middle
    */
    private void shiftArrayElements() {
        int nullIndex = 0;
        for (int i = 1; i < fabricTypes.length; i++) {
            if (fabricTypes[i] == null) {
                nullIndex = i;
                break;
            }
        }
        for (int i = nullIndex + 1; i < fabricTypes.length; i++) {
            if (fabricTypes[i] != null) {
                fabricTypes[nullIndex++] = fabricTypes[i];
                fabricTypes[i] = null;
            }
        }
    }

    /*
     * Method to check if a fabric type is valid (exists in FABRIC_TYPES)
     * @param fabricType - the fabric type to validate
     * @return true if the fabric type is valid, false otherwise
    */
    private boolean isValidFabricType(String fabricType) {
        // Fixed: changed toLowerCase to toUpperCase
        return Arrays.asList(FABRIC_TYPES).contains(fabricType.toUpperCase());
    }
}
