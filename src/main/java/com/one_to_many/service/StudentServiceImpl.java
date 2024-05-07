package com.one_to_many.service;

import com.one_to_many.model.AddressModel;
import com.one_to_many.model.StudentModel;
import com.one_to_many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel create(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    @Override
    public StudentModel getById(Long stuRoll) {
        return studentRepository.findById(stuRoll).orElse(null);
    }

    @Override
    public void deleteFromId(Long stuRoll) {
        studentRepository.deleteById(stuRoll);
    }

    @Override
    public StudentModel modify(Long stuRoll, StudentModel studentModel) {
        studentModel.setStuRoll(stuRoll);
        return studentRepository.save(studentModel);
    }


}
