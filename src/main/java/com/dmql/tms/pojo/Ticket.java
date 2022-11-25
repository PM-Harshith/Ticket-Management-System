package com.dmql.tms.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private int ticketId;

    @Column
    private int ticketCategory;

    @Column
    private int ticketStatus;

    @Column
    private String ticket_description;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column
    private int created_by_id;

    @Column
    private int agent_id;
}
