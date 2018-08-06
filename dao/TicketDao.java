package com.flight.dao;


import com.flight.cache.CacheManager;
import com.flight.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketDao {
    private static Map<Integer, Ticket> allTickets = new HashMap<>();

    @Autowired
    CacheManager cacheManager;

    public static void init(){
        for(int i =1; i< 5; i++) {
            Ticket ticket = new Ticket(i);
            allTickets.put(i, ticket);
        }
    }

    public Ticket getTicketById(int id) {
        String cacheKey = "ticket-" + id;
        if (cacheManager.get(cacheKey) == null){
            cacheManager.put(cacheKey, allTickets.get(id));
        }
        return (Ticket) cacheManager.get(cacheKey);
    }

    public boolean updateTicketById(Ticket ticket){
        try {
            allTickets.put(ticket.getId(), ticket);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
