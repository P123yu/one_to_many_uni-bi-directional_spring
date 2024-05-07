package com.one_to_many.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties("address")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuRoll;
    private String stuName;
    private Double stuMarks;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "student")
//  //  @JoinColumn(name = "stu_roll", referencedColumnName = "stuRoll")  // specifying the foreign key column
//    private Set<AddressModel> address = new TreeSet<>();



@JsonBackReference
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "studentModel")
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="studentModel",orphanRemoval = false)
    private Set<AddressModel> address = new TreeSet<>();

}
