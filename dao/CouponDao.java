package com.flight.dao;


import com.flight.cache.CacheManager;
import com.flight.entities.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CouponDao {
    private static Map<Integer, Coupon> allCoupons = new HashMap<>();

    @Autowired
    CacheManager cacheManager;

    public static void init() {
        for(int i=0; i<5; i++){
            Coupon coupon = new Coupon(i, i*10);
            allCoupons.put(i,coupon);
        }
    }
    public Coupon getCouponByID(int id) {
        String cacheKey = "coupon-"+id;
        if(cacheManager.get(cacheKey) == null) {
            cacheManager.put(cacheKey, allCoupons.get(id));
        }
        return (Coupon) cacheManager.get(cacheKey);
    }

    public boolean updateCouponById(Coupon coupon){
        try {
            allCoupons.put(coupon.getId(), coupon);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
