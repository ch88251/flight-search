package com.cfhayes.demo.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfhayes.demo.flight.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
