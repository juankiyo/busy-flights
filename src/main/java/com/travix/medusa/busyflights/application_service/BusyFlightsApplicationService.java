package com.travix.medusa.busyflights.application_service;

import com.travix.medusa.busyflights.converter.FlightRequestConverter;
import com.travix.medusa.busyflights.converter.FlightResponseConverter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service_access.CrazyAirServiceAccess;
import com.travix.medusa.busyflights.service_access.ToughJetServiceAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusyFlightsApplicationService {

    private final CrazyAirServiceAccess crazyAirServiceAccess;
    private final ToughJetServiceAccess toughJetServiceAccess;
    private final FlightRequestConverter flightRequestConverter;
    private final FlightResponseConverter flightResponseConverter;


    @Autowired
    public BusyFlightsApplicationService(CrazyAirServiceAccess crazyAirServiceAccess,
                                         ToughJetServiceAccess toughJetServiceAccess,
                                         FlightRequestConverter flightRequestConverter,
                                         FlightResponseConverter flightResponseConverter) {
        this.crazyAirServiceAccess = crazyAirServiceAccess;
        this.toughJetServiceAccess = toughJetServiceAccess;
        this.flightRequestConverter = flightRequestConverter;
        this.flightResponseConverter = flightResponseConverter;
    }

    public List<BusyFlightsResponse> getBusyFlights(BusyFlightsRequest busyFlightsRequest) {
        List<BusyFlightsResponse> busyFlightsResponseList = new ArrayList<>();
        List<CrazyAirResponse> crazyAirFlightsList = crazyAirServiceAccess
                .getCrazyAirFlights(flightRequestConverter.convertToCrazyAirRequest(busyFlightsRequest));
        List<ToughJetResponse> toughJetFlightsList = toughJetServiceAccess
                .getToughJetFlights(flightRequestConverter.convertToToughJetRequest(busyFlightsRequest));

        //Convert supplier response into busyFlightResponse and add it to busyFlights list
        crazyAirFlightsList.forEach(crazyAirResponse -> busyFlightsResponseList
                .add(flightResponseConverter.convert(crazyAirResponse)));
        toughJetFlightsList.forEach(toughJetResponse -> busyFlightsResponseList
                .add(flightResponseConverter.convert(toughJetResponse)));
        return busyFlightsResponseList;
    }
}
