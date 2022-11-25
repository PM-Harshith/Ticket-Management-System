package com.dmql.tms.pojo;

import javax.persistence.*;

@Entity
@Table(name = "ticket_status")
public class TicketStatus {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String status;

}
