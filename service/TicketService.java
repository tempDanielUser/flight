package com.flight.service;

import com.flight.dao.TicketDao;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Service
@RequestMapping("/ticket")
public class TicketService {

    @Autowired
    TicketDao ticketDao;

    @GetMapping("/valid/{id}")
    public boolean isValidTicket(int id){
        return ticketDao.getTicketById(id) != null;

    }

    @VisibleForTesting
    public void setDao(TicketDao dao){
        this.ticketDao = dao;
    }
}
