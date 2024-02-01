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
        //result will hold the formatted string
        StringBuilder result = new StringBuilder();
        //lastYear and lastMonth are used to keep track of current year and month
        int lastYear = -1;
        int lastMonth = -1;

        // Assuming the trips are already in the correct order
        for (int i = 0; i < tripsLength; i++) {
            Trip trip = trips[i];
            int year = Trip.getYear(trip.getArrival());
            int month = Trip.getMonth(trip.getArrival());

            // If the year has changed, add a new line and the year
            if (year != lastYear) {
                if (lastYear != -1) result.append("\n");
                result.append(year).append(" (Year)\n");
                lastYear = year;
                lastMonth = -1;
            }

            // If the month has changed, add a new line and the month
            if (month != lastMonth) {
                result.append("--").append(month).append(" (Month)\n");
                lastMonth = month;
            }
            // Add the formatted trip details
            result.append("----")
                .append(fmtString("City", trip.getCity()))
                .append(", ")
                .append(fmtString("Country", trip.getCountry()))
                .append(" (Place)\n");
        }

        return result.toString();
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
