package com.travix.medusa.busyflights.suppliers.crazyair.domain;

import javax.persistence.*;

@Entity
@Table(name = "crazyair")
public class CrazyAir {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "airline")
    private String airline;

    @Column(name = "price")
    private double price;

    @Column(name = "cabinclass")
    private String cabinclass;

    @Column(name = "departure_airport_code")
    private String departureAirportCode;

    @Column(name = "destination_airport_code")
    private String destinationAirportCode;

    @Column(name = "departure_date")
    private String departureDate;

    @Column(name = "arrival_date")
    private String arrivalDate;

    @Column(name = "available_seats")
    private int availableSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
