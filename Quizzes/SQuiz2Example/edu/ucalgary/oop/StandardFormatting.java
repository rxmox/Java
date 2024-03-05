/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

//package edu.ucalgary.oop;

// Format with key and whitespace, then value
interface StandardFormatting {
    default String formatOutput(String key, String value) {
        if (key.length() <= 5) {
            // For keys of length 5 or less, add two tabs
            return key + ":\t\t" + value;
        } else if (key.length() == 6) {
            // For keys of exactly length 6, also add two tabs to match the expected output
            return key + ":\t\t" + value; // Corrected to use two tabs directly
        } else if (key.length() <= 14) {
            // For keys longer than 6 but up to 14 characters in length, use one tab
            return key + ":\t" + value;
        } else {
            // For keys longer than 14 characters, just use a colon and a space
            return key + ": " + value;
        }
    }
}



