package com.travix.medusa.busyflights.suppliers.toughjet.controller;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.suppliers.toughjet.application_service.ToughJetApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/toughjet", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToughJetController {

    private final ToughJetApplicationService toughJetApplicationService;

    @Autowired
    public ToughJetController(ToughJetApplicationService toughJetApplicationService) {
        this.toughJetApplicationService = toughJetApplicationService;
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public List<ToughJetResponse> getFlights(@RequestBody ToughJetRequest toughJetRequest) {
        return toughJetApplicationService.getFlights(toughJetRequest);
    }
}
