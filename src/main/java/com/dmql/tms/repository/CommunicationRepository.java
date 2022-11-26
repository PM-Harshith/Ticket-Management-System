package com.dmql.tms.repository;

import com.dmql.tms.pojo.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Integer> {
}
