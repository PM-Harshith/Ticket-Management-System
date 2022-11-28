package com.dmql.tms.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "ticket")
@Data
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
    @CsvBindByName(column = "ticket_description")
    private String ticket_description;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column
    private int created_by_id;

    @Column
    private int agent_id;

    @Transient
    @CsvBindByName(column = "category_name")
    private String category_name;

    @Transient
    @CsvBindByName(column = "status_name")
    private String status_name;

    @CsvBindByName(column = "sub_category")
    @Transient
    private String subCategory;
}
