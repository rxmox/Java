/*
 * Version: student code
*/

package edu.ucalgary.oop;

import java.util.Arrays;

public class Willow extends Plant implements DisplaySpecifications {
    private int height;
    private int age;

    // Default value for commonName
    private static final String DEFAULT_COMMON_NAME = "Weeping Willow";

    // Default climate zones for Willow
    private static final String[] DEFAULT_CLIMATE_ZONES = {"4a", "4b", "10a"};

    // Constructor with all variables
    public Willow(String commonName, String[] climateZones, String careInstructions, int height, int age) {
        super(commonName, climateZones, careInstructions);

        setHeight(height);
        setAge(age);
    }

    // Constructor without specifying climate zones
    public Willow(String commonName, String careInstructions, int height, int age) {
        super(commonName, DEFAULT_CLIMATE_ZONES, careInstructions);
        setHeight(height);
        setAge(age);
    }

    // Constructor without specifying the common name
    public Willow(String[] climateZones, String careInstructions, int height, int age) {
        super(DEFAULT_COMMON_NAME, climateZones, careInstructions);
        setHeight(height);
        setAge(age);
    }

    // Constructor without specifying both climate zones and the common name
    public Willow(String careInstructions, int height, int age) {
        super(DEFAULT_COMMON_NAME, DEFAULT_CLIMATE_ZONES, careInstructions);
        setHeight(height);
        setAge(age);
    }

    // Getters and setters
    public int getHeight() {
        return height; 
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be a positive number greater than 0 and less than or equal to 100.");
        }
        this.age = age;
    }

    // Implementing displaySpecifications method
    public String displaySpecifications(String commonName, String[] climateZones, String careInstructions) {
        return DisplaySpecifications.displaySpecifications(commonName, climateZones, careInstructions);
    }
    
}

