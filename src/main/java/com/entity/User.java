package com.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;


}
