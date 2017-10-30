package com.travix.medusa.busyflights.suppliers.crazyair.data_service;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.suppliers.crazyair.data_access.CrazyAirRepository;
import com.travix.medusa.busyflights.suppliers.crazyair.domain.CrazyAir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrazyAirDataService {

    private final CrazyAirRepository crazyAirRepository;

    @Autowired
    public CrazyAirDataService(CrazyAirRepository crazyAirRepository) {
        this.crazyAirRepository = crazyAirRepository;
    }

    public List<CrazyAir> getFlights(CrazyAirRequest crazyAirRequest, boolean isOneWayFlight) {
        String departureAirportCode = isOneWayFlight ? crazyAirRequest.getOrigin() : crazyAirRequest.getDestination();
        String destinationAirportCode = isOneWayFlight ? crazyAirRequest.getDestination() : crazyAirRequest.getOrigin();
        String departureDate = isOneWayFlight ? crazyAirRequest.getDepartureDate() : crazyAirRequest.getReturnDate();

        return crazyAirRepository.findByDepartureAirportCodeAndDestinationAirportCodeAndDepartureDateContaining(
                departureAirportCode, destinationAirportCode, departureDate);
    }
}