package com.dmql.tms.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ticket_status")
@Data
public class TicketStatus {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String status;

}
