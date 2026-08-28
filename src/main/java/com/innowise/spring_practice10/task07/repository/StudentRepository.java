package com.innowise.spring_practice10.task07.repository;

import com.innowise.spring_practice10.task07.model.Student;
import com.innowise.spring_practice10.task07.model.Student.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStatus(Status status);
    List<Student> findByDepartment(String department);
}
