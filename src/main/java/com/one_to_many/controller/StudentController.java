package com.one_to_many.controller;


import com.one_to_many.model.StudentModel;
import com.one_to_many.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    // getAll
    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<StudentModel> studentModel=studentServiceImpl.getAll();
        if(!studentModel.isEmpty()){
            return ResponseEntity.ok(studentModel);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not find getAll");
        }
    }


    // create

    @PostMapping("/post")
    public ResponseEntity<?>create(StudentModel studentModel){
        StudentModel student=studentServiceImpl.create(studentModel);
        if(student!=null){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not created");
        }
    }

    // getById
    @GetMapping("/getById/{rollNo}")
    public ResponseEntity<?>getById(@PathVariable Long rollNo){
        StudentModel studentModel=studentServiceImpl.getById(rollNo);
        if(studentModel!=null){
            return ResponseEntity.ok(studentModel);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched by id");
        }
    }

    // deleteFromId
    @DeleteMapping("/deleteById/{stuRoll}")
    public ResponseEntity<?>deleteFromId(@PathVariable Long stuRoll){
        try{
            studentServiceImpl.deleteFromId(stuRoll);
            return ResponseEntity.ok("deleted successfully id "+Long.toString(stuRoll));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted based on given id");
        }

    }



    // modify student table
    @PutMapping("/modify/{stuRoll}")
    public ResponseEntity<?>modify(@PathVariable Long stuRoll,@RequestBody StudentModel studentModel){
        StudentModel student=studentServiceImpl.modify(stuRoll,studentModel);
        if(student!=null){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not updated");
        }
    }


}
