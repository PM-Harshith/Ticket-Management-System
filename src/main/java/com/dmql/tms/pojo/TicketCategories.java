package com.dmql.tms.pojo;


import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ticket_categories")
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class TicketCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="category_name")
    @CsvBindByName(column = "category_name")
    private String categoryName;
}
