package com.travix.medusa.busyflights.suppliers.toughjet.converter;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.suppliers.toughjet.domain.ToughJet;
import com.travix.medusa.busyflights.suppliers.toughjet.mapper.ToughJetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToughJetConverter {

    private final ToughJetMapper toughJetMapper;

    @Autowired
    public ToughJetConverter(ToughJetMapper toughJetMapper) {
        this.toughJetMapper = toughJetMapper;
    }

    public ToughJet convert(ToughJetRequest toughJetRequest) {
       return toughJetMapper.map(toughJetRequest, ToughJet.class);
    }

    public ToughJetResponse convert(ToughJet toughJet) {
        return toughJetMapper.map(toughJet, ToughJetResponse.class);
    }
}
