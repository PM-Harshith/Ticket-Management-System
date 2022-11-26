package com.dmql.tms.repository;

import com.dmql.tms.pojo.TicketCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<TicketCategories, Integer> {
     Optional<TicketCategories> getByCategoryName(String categoryName);

}
