package com.travix.medusa.busyflights.suppliers.crazyair.converter;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.suppliers.crazyair.domain.CrazyAir;
import com.travix.medusa.busyflights.suppliers.crazyair.mapper.CrazyAirMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirConverter {

    private final CrazyAirMapper crazyAirMapper;

    @Autowired
    public CrazyAirConverter(CrazyAirMapper crazyAirMapper) {
        this.crazyAirMapper = crazyAirMapper;
    }

    public CrazyAir convert(CrazyAirRequest crazyAirRequest) {
        return crazyAirMapper.map(crazyAirRequest, CrazyAir.class);
    }

    public CrazyAirResponse convert(CrazyAir crazyAir) {
        return crazyAirMapper.map(crazyAir, CrazyAirResponse.class);
    }
}
