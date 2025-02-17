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

    @Autowired
    private SchoolService schoolService;

    @Override
    public boolean createStudent(Student student) {
        if (student == null) {
            return false;
        }

        student.setActive(true);
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
        if (student == null) {
            return false;
        }

        student.setActive(false);
        return updateStudent(student);
    }

    @Override
    public boolean restoreStudentById(Long studentId) {
        Student student = getById(studentId);

        if (student == null || !schoolService.getById(student.getSchool().getId()).isActive()) {
            return false;
        }

        student.setActive(true);
        return updateStudent(student);
    }

}
