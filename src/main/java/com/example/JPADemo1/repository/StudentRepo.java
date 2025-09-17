package com.example.JPADemo1.repository;



import com.example.JPADemo1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findByTechnology(String tech);

    @Query(nativeQuery = true,
    value = "select * from student where gender =:gender AND technology =:technology")
    List<Student> findByGenderAndTechnology(
            @Param("gender") String gender,@Param("technology") String technology
    );
}
