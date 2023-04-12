package com.example.studentapplication.student.repository;

import com.example.studentapplication.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
