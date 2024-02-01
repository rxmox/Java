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
    public Itinerary(String[][] myTrips) {
        for(int i = 0; i < myTrips.length; i++) {
            this.trips[i] = new Trip(myTrips[i]);
            tripsLength = i + 1;
        }
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }

    public String formatByArrival() {
        StringBuilder result = new StringBuilder();
        int lastYear = -1;
        int lastMonth = -1;

        // Assuming the trips are already in the correct order
        for (int i = 0; i < tripsLength; i++) {
            Trip trip = trips[i];
            int year = Trip.getYear(trip.getArrival());
            int month = Trip.getMonth(trip.getArrival());

            if (year != lastYear) {
                if (lastYear != -1) result.append("\n");
                result.append(year).append(" (Year)\n");
                lastYear = year;
                lastMonth = -1;
            }

            if (month != lastMonth) {
                result.append("--").append(month).append(" (Month)\n");
                lastMonth = month;
            }

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
        String [][][] dates = new String[3][12][20];
        int j = 0;
        int newYear = 0;
        int newMonth = 0;
        for(int i = 0; i < tripsLength; i++){
            int year = trips[i].getYear(trips[i].getArrival()) - 2021;
            int month = month = trips[i].getMonth(trips[i].getArrival()) - 1;
            String city = trips[i].getCity();
            String country = trips[i].getCountry();
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
