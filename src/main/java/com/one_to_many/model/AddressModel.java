package com.one_to_many.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String City;

   //@JsonBackReference
    //@JsonIgnore

    // default fetch type for ManyToOne: EAGER
    //@ManyToOne(fetch = FetchType.LAZY)

//    @JsonIgnore


    @JsonManagedReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "stu_roll")

    private StudentModel studentModel;
}
