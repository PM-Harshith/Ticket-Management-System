package com.dmql.tms.pojo;

import javax.persistence.*;

@Entity
@Table(name = "user_role_association")
public class UserRoleAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "user_id")
    private int userId;
}
