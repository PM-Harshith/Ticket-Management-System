package com.dmql.tms.controller;

import com.dmql.tms.pojo.Ticket;
import com.dmql.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket/create")
    private ResponseEntity createTicket(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/ticket/get")
    private ResponseEntity<Ticket> getTicket(@RequestParam String id) {
        Ticket ticket = ticketService.getTicket(Integer.valueOf(id));
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

}
