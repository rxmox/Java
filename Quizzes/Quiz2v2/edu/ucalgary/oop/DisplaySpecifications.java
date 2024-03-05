/*
 * Version: student code
*/

package edu.ucalgary.oop;

import java.util.Arrays;

public interface DisplaySpecifications {
    /**
     * Formats the plant's specifications.
     *
     * @param commonName       The common name of the plant.
     * @param climateZones     An array of climate zones for the plant.
     * @param careInstructions The care instructions for the plant.
     * @return A formatted string representing the plant's specifications.
     *
     * Example:
     * If commonName = "Example Plant", climateZones = {"1a", "2b", "5a"}, and careInstructions = "Water regularly, keep in sunlight.",
     * the returned string should be:
     * "Example Plant
     * Zone: 1a, 2b, 5a
     * Care:
     * Water regularly, keep in sunlight."
     */
    static String displaySpecifications(String commonName, String[] climateZones, String careInstructions) {
        // Convert climate zones array to comma-delimited list
        String climateZonesList = String.join(", ", climateZones);

        // Format and return the specifications
        return String.format("%s\nZone: %s\nCare:\n%s", commonName, climateZonesList, careInstructions);
    }
}


