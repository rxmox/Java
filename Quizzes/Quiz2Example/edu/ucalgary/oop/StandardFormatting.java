/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

// Format with key and whitespace, then value
interface StandardFormatting {
    default String formatOutput(String key, String value) {
        String text;
        if (key.length() <= 5) {
            text = key + ":\t\t" + value;
            return text;
        }

        if (key.length() > 6 && key.length() < 14) {
            text = key + ":\t" + value;
            return text;
        }

        return "";
    }
}
