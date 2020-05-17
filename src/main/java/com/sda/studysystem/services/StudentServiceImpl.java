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
        student.setStudentId(student.getStudentId());
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student == null) {
            return false;
        }
        studentRepository.saveAndFlush(student);
        return true;
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.getOne(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteStudentById(Long studentId) {
        Student student = getById(studentId);
        if (studentId == null) {
            return false;
        }
        student.setActive(false);
        updateStudent(student);
        return false;
    }

    private String getNewStudentId() {
        double studentId = Math.random();
        return "" + studentId;
    }

    @Override
    public boolean restoreStudentById(Long studentId) {
        Student student = getById(studentId);
        if (studentId == null) {
            return false;
        }
        student.setActive(true);
        return updateStudent(student);
    }

}
