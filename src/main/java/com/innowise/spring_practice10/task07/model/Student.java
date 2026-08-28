package com.innowise.spring_practice10.task07.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String department;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])(/)(0?[1-9]|1[0-2])(/)(\\d{4})$",
            message = "Must be in DD/MM/YYYY format.")
    private String enrollment;
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Status status;

    public Student(String firstName, String lastName, String department, String enrollment, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.enrollment = enrollment;
        this.status = status;
    }

    public enum Status {ACTIVE, INACTIVE}
}
