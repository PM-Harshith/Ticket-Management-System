package com.dmql.tms.repository;

import com.dmql.tms.pojo.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<TicketStatus, Integer> {

}
