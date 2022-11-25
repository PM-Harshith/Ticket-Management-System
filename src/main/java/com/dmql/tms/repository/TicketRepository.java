package com.dmql.tms.repository;

import com.dmql.tms.pojo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    public Optional<Ticket> getByTicketId(Integer ticketId);
}
