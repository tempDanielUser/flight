package com.flight.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Ticket {
    private Integer id;

    public Ticket(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
