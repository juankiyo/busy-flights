package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.application_service.BusyFlightsApplicationService;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.BadFlightRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.constants.BusyFlightsConstants.EXCEPTION_MAX_PASSENGERS;

@RestController
@RequestMapping(value = "/busyflights", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusyFlightsController {

    private final BusyFlightsApplicationService busyFlightsApplicationService;

    @Value("${number.of.passengers.max}")
    protected int maxNumberOfPassengers;

    @Autowired
    public BusyFlightsController(BusyFlightsApplicationService busyFlightsApplicationService) {
        this.busyFlightsApplicationService = busyFlightsApplicationService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<BusyFlightsResponse> getFlights(@RequestBody BusyFlightsRequest busyFlightsRequest) throws BadFlightRequestException {
        checkFlightRequest(busyFlightsRequest);
        return busyFlightsApplicationService.getBusyFlights(busyFlightsRequest)
                .stream().sorted().collect(Collectors.toList());
    }

    private void checkFlightRequest(BusyFlightsRequest busyFlightsRequest) {
        if (busyFlightsRequest.getNumberOfPassengers() > maxNumberOfPassengers) {
            throw new BadFlightRequestException(HttpStatus.BAD_REQUEST, EXCEPTION_MAX_PASSENGERS);
        }
    }
}
