package com.innowise.spring_practice10.task07.controller;

import com.innowise.spring_practice10.task07.model.Student;
import com.innowise.spring_practice10.task07.model.Student.Status;
import com.innowise.spring_practice10.task07.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.findAllStudents();
        return students.isEmpty() ?
                new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/all/department/{department}")
    public List<Student> getStudentsByDepartment(@PathVariable("department") String department) {
        return this.service.findStudentsByDepartment(department);
    }

    @GetMapping("/all/status/{status}")
    public List<Student> getStudentsByStatus(@PathVariable("status") Status status) {
        return this.service.findStudentsByStatus(status);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") long studentId) {
        return this.service.findStudentById(studentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student student) {
        Student s = this.service.saveStudent(student);
        log.info("Creating student: {}", student);
        return s;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") long studentId) {
        return this.service.updateStudent(student, studentId);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") long studentId) {
        this.service.deleteStudentById(studentId);
    }
}
