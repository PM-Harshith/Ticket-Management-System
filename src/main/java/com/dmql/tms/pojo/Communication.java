package com.dmql.tms.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
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
