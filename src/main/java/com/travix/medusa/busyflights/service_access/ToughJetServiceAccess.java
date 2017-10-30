package com.travix.medusa.busyflights.service_access;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ToughJetServiceAccess {

    private final RestTemplate restTemplate;

    @Value("${supplier.toughjet.url}")
    protected String toughJetUrl;

    @Autowired
    public ToughJetServiceAccess(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ToughJetResponse> getToughJetFlights(ToughJetRequest toughJetRequest) {
        return Arrays.asList(restTemplate.postForObject(toughJetUrl, toughJetRequest, ToughJetResponse[].class));
    }
}
