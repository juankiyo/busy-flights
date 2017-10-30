package com.travix.medusa.busyflights.suppliers.crazyair.data_access;

import com.travix.medusa.busyflights.suppliers.crazyair.domain.CrazyAir;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrazyAirRepository extends JpaRepository<CrazyAir, Long> {
    List<CrazyAir> findByDepartureAirportCodeAndDestinationAirportCodeAndDepartureDateContaining(
            String departureAirportCode, String destinationAirportCode, String departureDate);
}
