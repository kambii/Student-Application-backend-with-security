package com.example.studentapplication.student.controller;

import com.example.studentapplication.student.model.Student;
import com.example.studentapplication.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createdStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping("/update-student{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(id,student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete-student{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
