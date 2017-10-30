package com.travix.medusa.busyflights.service_access;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CrazyAirServiceAccess {

    private final RestTemplate restTemplate;

    @Value("${supplier.crazyair.url}")
    protected String crazyAirUrl;

    @Autowired
    public CrazyAirServiceAccess(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CrazyAirResponse> getCrazyAirFlights(CrazyAirRequest crazyAirRequest) {
        return Arrays.asList(restTemplate.postForObject(crazyAirUrl, crazyAirRequest, CrazyAirResponse[].class));
    }
}
