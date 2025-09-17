package com.example.JPADemo1.service;


import com.example.JPADemo1.model.Student;
import com.example.JPADemo1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllstd() {
        return studentRepo.findAll();
    }

    public void addstd(Student student) {
        studentRepo.save(student);
    }

    public Student getstdbyId(int rno) {
        return studentRepo.findById(rno).orElse(null);
    }

    public void updstd(int id, Student student) {
        Student existing = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(student.getName());
        existing.setGender(student.getGender());
        existing.setTechnology(student.getTechnology());

        studentRepo.save(existing);
    }

    public void delstd(int id) {
        studentRepo.deleteById(id);
    }


    public List<Student> getstdByTechnology(String tech) {
        return studentRepo.findByTechnology(tech);
    }

    public List<Student> getStudentByGenderAndTechnology(String gender, String technology) {
        return studentRepo.findByGenderAndTechnology(gender,technology);
    }
}
