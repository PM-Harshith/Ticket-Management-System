package com.dmql.tms.service;

import com.dmql.tms.pojo.Ticket;
import com.dmql.tms.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public void createTicket(Ticket ticket) {
        ticketRepository.saveAndFlush(ticket);
    }

    public Ticket getTicket(Integer ticketId) {
        return ticketRepository.getByTicketId(ticketId).orElse(null);
    }
}
