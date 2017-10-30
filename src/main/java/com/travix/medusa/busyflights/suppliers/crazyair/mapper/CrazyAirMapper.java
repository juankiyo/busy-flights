package com.travix.medusa.busyflights.suppliers.crazyair.mapper;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.suppliers.crazyair.domain.CrazyAir;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(CrazyAir.class, CrazyAirRequest.class)
                .field("departureAirportCode", "origin")
                .field("destinationAirportCode", "destination")
                .field("departureDate", "departureDate")
                .field("arrivalDate", "returnDate")
                .byDefault().register();
        factory.classMap(CrazyAir.class, CrazyAirResponse.class).byDefault().register();
    }

}
