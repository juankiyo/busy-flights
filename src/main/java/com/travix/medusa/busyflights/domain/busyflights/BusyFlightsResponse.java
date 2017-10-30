package com.travix.medusa.busyflights.domain.busyflights;

import java.util.Locale;

public class BusyFlightsResponse implements Comparable<BusyFlightsResponse> {
    private String airline;
    private String supplier;
    private double fare;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public BusyFlightsResponse() {
    }

    public BusyFlightsResponse(String airline, String supplier, double fare, String departureAirportCode,
                               String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getFare() {
        return Double.valueOf(String.format(Locale.ROOT, "%.2f", fare));
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public int compareTo(BusyFlightsResponse busyFlightsResponse) {
        if (this.fare > busyFlightsResponse.getFare()) {
            return -1;
        } else if (busyFlightsResponse.getFare() > this.fare) {
            return 1;
        }
        return 0;
    }
}
