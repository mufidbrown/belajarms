package com.mufid.companyms.company;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "company_table")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "company")
//    private List<Job> jobs;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "company")
//    private List<Review> reviews;

}

