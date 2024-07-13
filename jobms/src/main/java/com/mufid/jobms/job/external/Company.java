package com.mufid.jobms.job.external;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Entity
@Getter
@Setter
//@Table(name = "company_table")
public class Company {


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

