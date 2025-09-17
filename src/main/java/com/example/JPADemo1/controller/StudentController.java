package com.example.JPADemo1.controller;


import com.example.JPADemo1.model.Student;
import com.example.JPADemo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllstd();
    }

    @GetMapping("/students/{rno}")
    public ResponseEntity<Student> getStudentById(@PathVariable int rno){
        Student student=studentService.getstdbyId(rno);
        if(student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<String> addStudents(@RequestBody Student student){
        studentService.addstd(student);
        return new ResponseEntity<>("Added....",HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updstd(id, student);
        return "Updated Successfully!!!";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.delstd(id);
        return "Deleted Successfully!!!";
    }

    @GetMapping("/students/technology/{tech}")
    public List<Student> getStudentsByTechnology(@PathVariable String tech){
        return studentService.getstdByTechnology(tech);
    }

    @PostMapping("/students/filter")
    public List<Student> getStudentByGenderAndTechnology(@RequestParam("gender") String gender,@RequestParam("technology") String technology){
        return studentService.getStudentByGenderAndTechnology(gender,technology);
    }

}
