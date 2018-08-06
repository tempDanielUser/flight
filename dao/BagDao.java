package com.flight.dao;

import com.flight.entities.Baggage;
import com.flight.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BagDao {

    private static Map<Integer,Map<Integer,Baggage>> allBaggage = new HashMap<>();

    public static void init(){
        for(int i = 1; i < 5; i++){
            Baggage baggage = new Baggage(i,i);
            updateBaggage(baggage);
        }
    }

    @Autowired
    CacheManager cacheManager;

    public Baggage getBaggageByIDAndFlightID(int flightId, int bagID) {
        String cacheKey = "bag-" + flightId + "-" + bagID;
        if(cacheManager.get(cacheKey) == null) {
            if (allBaggage.get(flightId) == null) {
                cacheManager.put(cacheKey, null);
            } else {
                cacheManager.put(cacheKey, allBaggage.get(flightId).get(bagID));
            }
        }
        return (Baggage) cacheManager.get(cacheKey);
    }

    public static boolean updateBaggage(Baggage baggage){
        try {
            allBaggage.computeIfAbsent(baggage.getFlightId(), k -> new HashMap<>());
            allBaggage.get(baggage.getFlightId()).put(baggage.getId(), baggage);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
