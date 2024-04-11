/**
 * @author Omar Ahmed
 * @version 1.5
 * @since 1.0
 */

package edu.ucalgary.oop;

import java.time.*;
import java.util.*;

public class VisitorParking {
    private HashMap<String, TreeSet<LocalDate>> parkingRecord = new HashMap<String, TreeSet<LocalDate>>();

    public VisitorParking() throws IllegalArgumentException { };

    public VisitorParking(String license) throws IllegalArgumentException {
        license = Parking.standardizeAndValidateLicence(license);
        TreeSet<LocalDate> reservationDates = new TreeSet<LocalDate>();
        reservationDates.add(LocalDate.now());
        reservationDates.add(LocalDate.now().plusDays(1));
        reservationDates.add(LocalDate.now().plusDays(2));
        parkingRecord.put(license, reservationDates);
    }

    public VisitorParking(String license, LocalDate date) throws IllegalArgumentException {
        license = Parking.standardizeAndValidateLicence(license);
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException();
        }

        TreeSet<LocalDate> reservationDates = new TreeSet<LocalDate>();
        reservationDates.add(date);
        reservationDates.add(date.plusDays(1));
        reservationDates.add(date.plusDays(2));
        parkingRecord.put(license, reservationDates);
    }

    public void addVisitorReservation(String license) throws IllegalArgumentException {
        license = Parking.standardizeAndValidateLicence(license);
        if (parkingRecord.containsKey(license)) {
            TreeSet<LocalDate> datesSet = parkingRecord.get(license);
            if(datesSet.contains(LocalDate.now())) {
                throw new IllegalArgumentException();
            }
            else {
                TreeSet<LocalDate> reservationDates = parkingRecord.get(license);
                reservationDates.add(LocalDate.now());
                reservationDates.add(LocalDate.now().plusDays(1));
                reservationDates.add(LocalDate.now().plusDays(2));
            }
        }
        else {
            int reservations = 0;
            for(String key: parkingRecord.keySet()) {
                TreeSet<LocalDate> datesSet = parkingRecord.get(key);
                if(datesSet.contains(LocalDate.now())) {
                    reservations++;
                }
                if(reservations == 2) { break; }
            }
            if (reservations == 2) { throw new IllegalArgumentException();}
            else {
                TreeSet<LocalDate> reservationDates = new TreeSet<LocalDate>();
                reservationDates.add(LocalDate.now());
                reservationDates.add(LocalDate.now().plusDays(1));
                reservationDates.add(LocalDate.now().plusDays(2));
                parkingRecord.put(license, reservationDates);
            }
        }
    }

    public void addVisitorReservation(String license, LocalDate date) throws IllegalArgumentException {
        license = Parking.standardizeAndValidateLicence(license);
        if (parkingRecord.containsKey(license)) {
            TreeSet<LocalDate> datesSet = parkingRecord.get(license);
            if(datesSet.contains(date)) {
                throw new IllegalArgumentException();
            }
            else {
                TreeSet<LocalDate> reservationDates = parkingRecord.get(license);
                reservationDates.add(date);
                reservationDates.add(date.plusDays(1));
                reservationDates.add(date.plusDays(2));
            }
        }
        else {
            int reservations = 0;
            for(String key: parkingRecord.keySet()) {
                TreeSet<LocalDate> datesSet = parkingRecord.get(key);
                if(datesSet.contains(date)) {
                    reservations++;
                }
                if(reservations == 2) { break; }
            }
            if (reservations == 2) { throw new IllegalArgumentException();}
            else {
                if (date.isBefore(LocalDate.now())) {
                    throw new IllegalArgumentException();
                }
        
                TreeSet<LocalDate> reservationDates = new TreeSet<LocalDate>();
                reservationDates.add(date);
                reservationDates.add(date.plusDays(1));
                reservationDates.add(date.plusDays(2));
                parkingRecord.put(license, reservationDates);
            }
        }
    }

    public boolean licenceIsRegisteredForDate(String license) {
        return licenceIsRegisteredForDate(license, LocalDate.now());
    }

    public boolean licenceIsRegisteredForDate(String license, LocalDate date) {
        license = Parking.standardizeAndValidateLicence(license);
        if(parkingRecord.containsKey(license)) {
            TreeSet<LocalDate> reservationDates = parkingRecord.get(license);
            if(reservationDates.contains(date)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return getLicencesRegisteredForDate(LocalDate.now());
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        ArrayList<String> licenses = new ArrayList<String>();
        for (String key : parkingRecord.keySet()) {
            if(parkingRecord.get(key).contains(date)){
                licenses.add(key);
            }
        }
        return licenses;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String license){
        license = Parking.standardizeAndValidateLicence(license);
        ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
        TreeSet<LocalDate> reservationDates = parkingRecord.get(license);
        for(LocalDate date: reservationDates) {
            dates.add(date);
        }
        return dates;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String license){
        ArrayList<LocalDate> dates = getAllDaysLicenceIsRegistered(license);
        ArrayList<LocalDate> startDays = new ArrayList<LocalDate>();
        for(int i = 0; i < dates.size(); i += 3){
            startDays.add(dates.get(i));
        }
        return startDays;
    }

    public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {
        HashMap<String, TreeSet<LocalDate>> reservations = new HashMap<String, TreeSet<LocalDate>>();
        for (String key : parkingRecord.keySet()) {
            ArrayList<LocalDate> reservationDates = getStartDaysLicenceIsRegistered(key);
            TreeSet<LocalDate> reservedDates = new TreeSet<>(reservationDates);
            reservedDates = (TreeSet<LocalDate>) reservedDates.descendingSet();
            reservations.put(key, reservedDates);
        }
        return reservations;
    }
}

