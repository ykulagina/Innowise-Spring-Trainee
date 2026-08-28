package com.innowise.spring_practice10.task07.service;

import com.innowise.spring_practice10.task07.repository.StudentRepository;
import com.innowise.spring_practice10.task07.model.Student;
import com.innowise.spring_practice10.task07.model.Student.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> findAllStudents() {
        return this.repo.findAll();
    }

    public Student findStudentById(long id) {
        return this.repo.findById(id).orElse(null);
    }

    public List<Student> findStudentsByStatus(Status status) {
        return this.repo.findByStatus(status);
    }

    public List<Student> findStudentsByDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            return this.repo.findByDepartment(department);
        } else {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
    }

    public Student saveStudent(Student student) {
        return this.repo.save(student);
    }

    public Student updateStudent(Student student, long id) {
        if (this.repo.findById(id).isEmpty()) {
            throw new NoSuchElementException("No student found.");
        } else {
            Student dbStudent = this.repo.findById(id).get();
            if (Objects.nonNull(student.getFirstName()) && !student.getFirstName().isEmpty()) {
                dbStudent.setFirstName(student.getFirstName());
            }
            if (Objects.nonNull(student.getLastName()) && !student.getLastName().isEmpty()) {
                dbStudent.setLastName(student.getLastName());
            }
            if (Objects.nonNull(student.getDepartment()) && !student.getDepartment().isEmpty()) {
                dbStudent.setDepartment(student.getDepartment());
            }
            if (Objects.nonNull(student.getEnrollment()) && !student.getEnrollment().isEmpty()) {
                dbStudent.setEnrollment(student.getEnrollment());
            }
            if (Objects.nonNull(student.getStatus())) {
                dbStudent.setStatus(student.getStatus());
            }
            return this.repo.save(dbStudent);
        }
    }

    public void deleteStudentById(long id) {
        this.repo.deleteById(id);
    }
}
