/*
 * Version: student code
*/

package edu.ucalgary.oop;

import java.util.Arrays;
import java.util.List;

public class Plant {
    private String commonName;
    private String[] climateZones;
    private String careInstructions;

    // List of valid climate zone options
    private static final List<String> VALID_CLIMATE_ZONES = Arrays.asList(
            "0a", "0b", "1a", "1b", "2a", "2b", "3a", "3b", "4a", "4b", "5a", "5b", "6a", "6b", "7a", "7b", "8a", "8b",
            "9a", "9b", "10a", "10b", "11a", "11b", "12a", "12b", "13a", "13b"
    );

    /**
     * Constructor for Plant object.
     *
     * @param commonName       The common name of the plant.
     * @param climateZones     An array of climate zones for the plant.
     * @param careInstructions The care instructions for the plant.
     */
    public Plant(String commonName, String[] climateZones, String careInstructions) {
        this.commonName = commonName;
        setClimateZones(climateZones);
        this.careInstructions = careInstructions;
    }

    /**
     * Gets the common name of the plant.
     *
     * @return The common name of the plant.
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * Sets the common name of the plant.
     *
     * @param commonName The common name of the plant.
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * Gets the climate zones of the plant.
     *
     * @return An array of climate zones for the plant.
     */
    public String[] getClimateZones() {
        return climateZones;
    }

    /**
     * Sets the climate zones of the plant.
     *
     * @param climateZones An array of climate zones for the plant.
     * @throws IllegalArgumentException if any climate zone is invalid.
     */
    public void setClimateZones(String[] climateZones) {
        for (int i = 0; i < climateZones.length; i++) {
            // Normalize input (convert to lowercase)
            climateZones[i] = climateZones[i].toLowerCase();
            // Validate climate zone
            if (!isValidClimateZone(climateZones[i])) {
                throw new IllegalArgumentException("Invalid climate zone. Please provide a valid climate zone.");
            }
        }
        this.climateZones = climateZones;
    }


    /**
     * Gets the care instructions for the plant.
     *
     * @return The care instructions for the plant.
     */
    public String getCareInstructions() {
        return careInstructions;
    }

    /**
     * Sets the care instructions for the plant.
     *
     * @param careInstructions The care instructions for the plant.
     */
    public void setCareInstructions(String careInstructions) {
        this.careInstructions = careInstructions;
    }

    /**
     * Validates whether a climate zone is valid.
     *
     * @param climateZone The climate zone to validate.
     * @return true if the climate zone is valid, otherwise false.
     */
    private boolean isValidClimateZone(String climateZone) {
        return VALID_CLIMATE_ZONES.contains(climateZone);
    }

    /**
     * Removes a specified climate zone from the plant.
     *
     * @param zoneToRemove The climate zone to remove.
     * @return true if the climate zone was successfully removed, otherwise false.
     */
    public boolean removeClimateZone(String zoneToRemove) {
        int index = -1;
        for (int i = 0; i < climateZones.length; i++) {
            if (climateZones[i].equalsIgnoreCase(zoneToRemove)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; // Zone to remove not found
        }
        // Shift elements to remove zone
        for (int i = index; i < climateZones.length - 1; i++) {
            climateZones[i] = climateZones[i+1];
        }
        climateZones = Arrays.copyOf(climateZones, climateZones.length - 1);
        return true;
    }

    /**
     * Adds a new climate zone to the plant.
     *
     * @param newZone The new climate zone to add.
     * @return true if the climate zone was successfully added, false if the array was full.
     * @throws IllegalArgumentException if the climate zone is invalid.
     */
    public boolean addClimateZone(String newZone) {
        if (climateZones.length >= 3) {
            return false; // Array is full
        }

        newZone = newZone.toLowerCase();

        // Add new zone
        climateZones = Arrays.copyOf(climateZones, climateZones.length + 1);
        climateZones[climateZones.length - 1] = newZone;
        return true;
    }
}

