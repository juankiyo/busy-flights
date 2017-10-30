package com.travix.medusa.busyflights.suppliers.crazyair.application_service;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.suppliers.crazyair.converter.CrazyAirConverter;
import com.travix.medusa.busyflights.suppliers.crazyair.data_service.CrazyAirDataService;
import com.travix.medusa.busyflights.suppliers.crazyair.domain.CrazyAir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyAirApplicationService {

    private final CrazyAirDataService crazyAirDataService;
    private final CrazyAirConverter crazyAirConverter;

    @Autowired
    public CrazyAirApplicationService(CrazyAirDataService crazyAirDataService, CrazyAirConverter crazyAirConverter) {
        this.crazyAirDataService = crazyAirDataService;
        this.crazyAirConverter = crazyAirConverter;
    }

    public List<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest) {
        List<CrazyAirResponse> crazyAirResponseList = new ArrayList<>();
        List<CrazyAir> oneWayFlights = crazyAirDataService.getFlights(crazyAirRequest, true);
        List<CrazyAir> returnFlights = crazyAirDataService.getFlights(crazyAirRequest, false);

        // Return flights matching number of passengers
        oneWayFlights.stream()
                .filter(crazyAir -> crazyAir.getAvailableSeats() >= crazyAirRequest.getPassengerCount())
                .forEach(crazyAir -> crazyAirResponseList.add(crazyAirConverter.convert(crazyAir)));
        returnFlights.stream()
                .filter(crazyAir -> crazyAir.getAvailableSeats() >= crazyAirRequest.getPassengerCount())
                .forEach(crazyAir -> crazyAirResponseList.add(crazyAirConverter.convert(crazyAir)));
        return crazyAirResponseList;
    }
}