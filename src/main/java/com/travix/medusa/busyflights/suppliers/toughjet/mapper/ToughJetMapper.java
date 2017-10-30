package com.travix.medusa.busyflights.suppliers.toughjet.mapper;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.suppliers.toughjet.domain.ToughJet;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ToughJetMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(ToughJet.class, ToughJetRequest.class)
                .field("departureAirportName", "from")
                .field("arrivalAirportName", "to")
                .field("outboundDateTime", "outboundDate")
                .field("inboundDateTime", "inboundDate")
                .byDefault().register();
        factory.classMap(ToughJet.class, ToughJetResponse.class).byDefault().register();
    }
}
