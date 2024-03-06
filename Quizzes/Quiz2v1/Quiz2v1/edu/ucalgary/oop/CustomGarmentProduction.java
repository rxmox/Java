/*
 * Version: student code
*/

//package edu.ucalgary.oop;

import java.util.Arrays;

public class CustomGarmentProduction extends Fabric implements DisplaySpecifications {

    // Fixed: added garmentCode and size fields 
    private String garmentCode;
    private char size;

    /**
     * Constructor for CustomGarmentProduction.
     * 
     * @param fabric      - The fabric type for the garment.
     * @param garmentCode - Code representing the garment.
     * @param size        - Size of the garment (S, M, L, or X).
     * @throws IllegalArgumentException if the size is not one of S, M, L, or X.
     */
    public CustomGarmentProduction(String fabric, String garmentCode, char size) throws IllegalArgumentException {
        super(fabric);
        validateSize(size);
        this.garmentCode = garmentCode;
        this.size = size;
    }

    /**
     * Constructor for CustomGarmentProduction.
     * 
     * @param fabrics     - Array of fabric types for the garment.
     * @param garmentCode - Code representing the garment.
     * @param size        - Size of the garment (S, M, L, or X).
     * @throws IllegalArgumentException if the size is not one of S, M, L, or X.
     */
    public CustomGarmentProduction(String[] fabrics, String garmentCode, char size) throws IllegalArgumentException {
        super(fabrics);
        validateSize(size);
        this.garmentCode = garmentCode;
        this.size = size;
    }

    // Getters and setters
    public String getGarmentCode() {
        // Fixed: changed Character.toString(size) to this.garmentCode
        return this.garmentCode;
    }

    public void setGarmentCode(String garmentCode) {
        this.garmentCode = garmentCode;
    }

    public char getSize() {
        return this.size;
    }

    public void setSize(char size) throws IllegalArgumentException {
        validateSize(size);
        // Fixed: changed this.size to size
        this.size = size;
    }

    /**
     * Validates the size of the garment.
     * 
     * @param size - Size of the garment (S, M, L, or X).
     * @throws IllegalArgumentException if the size is not one of S, M, L, or X.
     */
    private void validateSize(char size) throws IllegalArgumentException {
        // Fixed: removed the small letters from the conditions
        if (size != 'S' && size != 'M' && size != 'L' && size != 'X') {
            throw new IllegalArgumentException("Invalid size. Size must be one of S, M, L, or X.");
        }
    }


    // Fixed: changed the method so it matches the interface

    // Implementation of DisplaySpecifications interface
    public String formatOrder() {
        // Fixed: the order of the parameters was changed
        return DisplaySpecifications.formatOrder(getFabricTypes(), this.garmentCode, this.size);
    }
}
