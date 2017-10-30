package com.travix.medusa.busyflights.suppliers.toughjet.domain;

import javax.persistence.*;

@Entity
@Table(name = "toughjet")
public class ToughJet {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "base_price")
    private double basePrice;

    @Column(name = "tax")
    private double tax;

    @Column(name = "discount")
    private double discount;

    @Column(name = "departure_airport_name")
    private String departureAirportName;

    @Column(name = "arrival_airport_name")
    private String arrivalAirportName;

    @Column(name = "outbound_date_time")
    private String outboundDateTime;

    @Column(name = "inbound_date_time")
    private String inboundDateTime;

    @Column(name = "available_seats")
    private int availableSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
