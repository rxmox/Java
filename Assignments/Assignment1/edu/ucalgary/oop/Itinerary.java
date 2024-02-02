package edu.ucalgary.oop;

import java.util.Arrays;
//import java.util.Comparator;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Itinerary {
    private Trip[] trips = new Trip[20];
    private int tripsLength;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    //myTrips represents a collection of trip data, where each inner array contains the details of a single trip
    public Itinerary(String[][] myTrips) {
        for(int i = 0; i < myTrips.length; i++) {
            // Create a new Trip object for each trip
            // and store it in the array of trips
            this.trips[i] = new Trip(myTrips[i]);
            // Keep track of how many trips there are
            tripsLength = i + 1;
        }
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }

    public String formatByArrival() {
        StringBuilder formattedArrivals = new StringBuilder(); // Using StringBuilder for efficient string manipulation
        int lastArrivalYear = 0; 
        int lastArrivalMonth = 0; 
    
        for (int i = 0; i < tripsLength; i++) {
            int currentYear = trips[i].getYear(trips[i].getArrival()); 
            int currentMonth = trips[i].getMonth(trips[i].getArrival()); 
    
            if (currentYear != lastArrivalYear) {
                lastArrivalYear = currentYear;
                formattedArrivals.append(lastArrivalYear).append(" (Year)\n"); 
            }
            if (currentMonth != lastArrivalMonth) {
                lastArrivalMonth = currentMonth;
                formattedArrivals.append("--").append(lastArrivalMonth).append(" (Month)\n"); 
            }
    
            String destinationCity = trips[i].getCity(); 
            String destinationCountry = trips[i].getCountry(); 
            formattedArrivals.append("----")
                             .append(destinationCity).append(" (City), ")
                             .append(destinationCountry).append(" (Country) (Place)\n");
        }
    
        return formattedArrivals.toString(); 
    }
    

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        //create a 3D array to hold the formatted locations
        String [][][] dates = new String[3][12][20];

        //j is used to keep track of the number of locations in a month
        int j = 0;
        int newYear = 0;
        int newMonth = 0;

        // for each trip, add the formatted location to the 3D array
        for(int i = 0; i < tripsLength; i++){
            int year = trips[i].getYear(trips[i].getArrival()) - 2021;
            int month = month = trips[i].getMonth(trips[i].getArrival()) - 1;
            //get the city and country of the trip
            String city = trips[i].getCity();
            String country = trips[i].getCountry();
            //if the year has changed, reset j to 0
            if(month != newMonth){
                newMonth = month;
                j = 0;
            }
            dates[year][month][j] = city + " (City), " + country + " (Country)";
            j ++;
        }
        
        return dates;
    }
}
