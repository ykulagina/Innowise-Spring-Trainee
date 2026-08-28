package com.innowise.spring_practice10.task07.controller;

import com.innowise.spring_practice10.task07.model.Student;
import com.innowise.spring_practice10.task07.model.Student.Status;
import com.innowise.spring_practice10.task07.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/view-students")
public class StudentViewController {
    private StudentService service;

    public StudentViewController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public String filterStudents(@RequestParam(value = "department", required = false) String department, Model model) {
        List<Student> filteredStudents;
        if (department != null && !department.isEmpty()) {
            filteredStudents = this.service.findStudentsByDepartment(department);
            model.addAttribute("department", department);
            model.addAttribute("students", filteredStudents);
        } else {
            filteredStudents = this.service.findAllStudents();
            model.addAttribute("students", filteredStudents);
        }

        return "studentsAll";
    }


}
