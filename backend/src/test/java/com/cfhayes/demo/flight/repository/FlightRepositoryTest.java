package com.cfhayes.demo.flight.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.cfhayes.demo.flight.domain.Flight;

@DataJpaTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "spring.flyway.enabled=false"
})
@Sql(scripts = {"/test-data/seed-flights.sql"})
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void shouldHaveThreeSeededFlights() {
        // When
        long flightCount = flightRepository.count();
        
        // Then
        assertThat(flightCount).isEqualTo(3);
    }
    
    @Test
    void shouldHaveCorrectSeededFlightData() {
        // When
        var flights = flightRepository.findAll();
        
        // Then
        assertThat(flights).hasSize(3);
        
        // Verify specific flight data exists
        assertThat(flights).extracting(Flight::getOrigin)
            .containsExactlyInAnyOrder(
                "San Francisco (SFO)",
                "New York (JFK)", 
                "Los Angeles (LAX)"
            );
            
        assertThat(flights).extracting(Flight::getDestination)
            .containsExactlyInAnyOrder(
                "Taipei (TPE)",
                "London (LHR)",
                "New York (JFK)"
            );
            
        assertThat(flights).extracting(Flight::getTravelClass)
            .containsExactlyInAnyOrder(
                "Economy",
                "Business", 
                "Premium Economy"
            );
    }
}