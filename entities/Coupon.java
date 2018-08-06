package com.flight.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Coupon {
    Integer id;
    Integer discount;

    public Coupon(Integer id, Integer discount) {
        this.id = id;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
