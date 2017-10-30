package com.travix.medusa.busyflights.converter;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import static com.travix.medusa.busyflights.constants.BusyFlightsConstants.SUPPLIER_CRAZY_AIR;
import static com.travix.medusa.busyflights.constants.BusyFlightsConstants.SUPPLIER_TOUGH_JET;

@Component
public class FlightResponseConverter {

    public BusyFlightsResponse convert(CrazyAirResponse crazyAirResponse) {
        return new BusyFlightsResponse(crazyAirResponse.getAirline(),
                SUPPLIER_CRAZY_AIR,
                crazyAirResponse.getPrice(),
                crazyAirResponse.getDepartureAirportCode(),
                crazyAirResponse.getDestinationAirportCode(),
                crazyAirResponse.getDepartureDate(),
                crazyAirResponse.getArrivalDate());
    }

    public BusyFlightsResponse convert(ToughJetResponse toughJetResponse) {
        return new BusyFlightsResponse(toughJetResponse.getCarrier(),
                SUPPLIER_TOUGH_JET,
                toughJetResponse.getTotalPrice(),
                toughJetResponse.getDepartureAirportName(),
                toughJetResponse.getArrivalAirportName(),
                toughJetResponse.getOutboundDateTime(),
                toughJetResponse.getInboundDateTime());
    }
}
