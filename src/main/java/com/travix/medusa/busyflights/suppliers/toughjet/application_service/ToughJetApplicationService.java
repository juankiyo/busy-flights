package com.travix.medusa.busyflights.suppliers.toughjet.application_service;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.suppliers.toughjet.converter.ToughJetConverter;
import com.travix.medusa.busyflights.suppliers.toughjet.data_service.ToughJetDataService;
import com.travix.medusa.busyflights.suppliers.toughjet.domain.ToughJet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToughJetApplicationService {

    private final ToughJetDataService toughJetDataService;
    private final ToughJetConverter toughJetConverter;

    @Autowired
    public ToughJetApplicationService(ToughJetDataService toughJetDataService, ToughJetConverter toughJetConverter) {
        this.toughJetDataService = toughJetDataService;
        this.toughJetConverter = toughJetConverter;
    }

    public List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequest) {
        List<ToughJetResponse> toughJetResponseList = new ArrayList<>();
        List<ToughJet> oneWayFlights = toughJetDataService.getFlights(toughJetRequest, true);
        List<ToughJet> returnFlights = toughJetDataService.getFlights(toughJetRequest, false);

        // Return flights matching number of passengers
        oneWayFlights.stream()
                .filter(toughJet -> toughJet.getAvailableSeats() >= toughJetRequest.getNumberOfAdults())
                .forEach(toughJet -> toughJetResponseList.add(toughJetConverter.convert(toughJet)));
        returnFlights.stream()
                .filter(toughJet -> toughJet.getAvailableSeats() >= toughJetRequest.getNumberOfAdults())
                .forEach(toughJet -> toughJetResponseList.add(toughJetConverter.convert(toughJet)));
        return toughJetResponseList;
    }
}
