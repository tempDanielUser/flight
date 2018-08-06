package com.flight.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Baggage {
    private Integer id;
    private Integer flightId;

    public Baggage(Integer id, Integer flightId) {
        this.id = id;
        this.flightId = flightId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}
