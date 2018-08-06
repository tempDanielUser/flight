package com.flight.service;

import com.flight.dao.CouponDao;
import com.flight.dao.TicketDao;
import com.flight.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/coupon")
public class CouponService {

    @Autowired
    CouponDao couponDao;
    @GetMapping("/valid/{id}/{price}")
    public double isValidCoupon(int id, double price){
        Coupon coupon = couponDao.getCouponByID(id);
        return coupon == null? -1: price*(100 - coupon.getDiscount());
    }
}
