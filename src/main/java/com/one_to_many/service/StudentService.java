package com.one_to_many.service;


import com.one_to_many.model.AddressModel;
import com.one_to_many.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    // getAll
    List<StudentModel>getAll();


    // insert
    StudentModel create(StudentModel studentModel);

    // getById
    StudentModel getById(Long stuRoll);

    // deleteById
    void deleteFromId(Long stuRoll);

    // update
    StudentModel modify(Long addressId, StudentModel studentModel);

}
