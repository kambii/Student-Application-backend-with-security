package com.example.studentapplication.service;

import com.example.studentapplication.model.Student;
import com.example.studentapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }


    public Student createdStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Student currentStudent = studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        currentStudent.setDisplayName(student.getDisplayName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setGrade(student.getGrade());
        currentStudent.setEducationTitle(student.getEducationTitle());

        return studentRepository.save(currentStudent);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        studentRepository.delete(student);
    }
}
