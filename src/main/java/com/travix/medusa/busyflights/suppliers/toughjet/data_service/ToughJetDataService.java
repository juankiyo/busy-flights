package com.travix.medusa.busyflights.suppliers.toughjet.data_service;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.suppliers.toughjet.data_access.ToughJetRepository;
import com.travix.medusa.busyflights.suppliers.toughjet.domain.ToughJet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToughJetDataService {

    private final ToughJetRepository toughJetRepository;

    @Autowired
    public ToughJetDataService(ToughJetRepository toughJetRepository) {
        this.toughJetRepository = toughJetRepository;
    }

    public List<ToughJet> getFlights(ToughJetRequest toughJetRequest, boolean isOneWayFlight) {
        String departureAirportName = isOneWayFlight ? toughJetRequest.getFrom() : toughJetRequest.getTo();
        String arrivalAirportName = isOneWayFlight ? toughJetRequest.getTo() : toughJetRequest.getFrom();
        String outboundDateTime = isOneWayFlight ? toughJetRequest.getOutboundDate() : toughJetRequest.getInboundDate();

        return toughJetRepository.findByDepartureAirportNameAndArrivalAirportNameAndOutboundDateTimeContaining(
                departureAirportName, arrivalAirportName, outboundDateTime);
    }
}
