package com.travix.medusa.busyflights.suppliers.crazyair.controller;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.suppliers.crazyair.application_service.CrazyAirApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/crazyair", produces = MediaType.APPLICATION_JSON_VALUE)
public class CrazyAirController {

    private final CrazyAirApplicationService crazyAirApplicationService;

    @Autowired
    public CrazyAirController(CrazyAirApplicationService crazyAirApplicationService) {
        this.crazyAirApplicationService = crazyAirApplicationService;
    }

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    public List<CrazyAirResponse> getFlights(@RequestBody CrazyAirRequest crazyAirRequest) {
        return crazyAirApplicationService.getFlights(crazyAirRequest);
    }
}
