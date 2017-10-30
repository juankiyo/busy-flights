package com.travix.medusa.busyflights.suppliers.toughjet.data_access;

import com.travix.medusa.busyflights.suppliers.toughjet.domain.ToughJet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToughJetRepository extends JpaRepository<ToughJet, Long> {
    List<ToughJet> findByDepartureAirportNameAndArrivalAirportNameAndOutboundDateTimeContaining(
            String departureAirportName,
            String arrivalAirportName,
            String outboundDateTime);
}
