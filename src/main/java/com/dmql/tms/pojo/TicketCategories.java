package com.dmql.tms.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;


@Entity
@Table(name = "ticket_categories")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TicketCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="category_name")
    private String categoryName;
}
