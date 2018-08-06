package com.flight.service;

import com.flight.dao.BagDao;
import com.flight.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/baggage")
public class BaggageService {

    @Autowired
    BagDao bagDao;

    @GetMapping("/valid/{flightID}/{bagID}")
    public boolean isValidTicket(int flightID, int bagID ){
        return bagDao.getBaggageByIDAndFlightID(flightID, bagID) != null;

    }
}
