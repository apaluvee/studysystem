package com.sda.studysystem.services;

import com.sda.studysystem.models.Student;
import com.sda.studysystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of StudentsService
 *
 * @author Alar
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean createStudent(Student student) {
        if (student == null) {
            return false;
        }
        student.setStudentId(getNewStudentId());
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student == null || !studentRepository.existsById(student.getStudentId())) {
            return false;
        }
        studentRepository.saveAndFlush(student);
        return true;
    }

    @Override
    public Student getById(String studentId) {
        return studentRepository.getOne(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteStudentById(String studentId) {
        if (studentId.isEmpty() || !studentRepository.existsById(studentId)) {
            return false;
        }
        studentRepository.deleteById(studentId);
        return false;
    }

    private String getNewStudentId() {
        return null;
    }

}
