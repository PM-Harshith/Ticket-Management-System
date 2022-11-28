package com.dmql.tms.pojo;

import lombok.Data;

import jakarta.persistence.*;


@Entity
@Table
@Data
public class Communication {
    @Id
    @GeneratedValue
    private int id;

    private String type;
    private String message;
    private String email;
    private String phone_number;
    private int ticket_id ;
}
