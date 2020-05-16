package com.sda.studysystem.services;

import com.sda.studysystem.models.Student;

import java.util.List;

/**
 * Service to handle Student related operations
 * @author Alar
 */

public interface StudentService {

    /**
     * To create a new Student
     * @param student Student
     */
    boolean createStudent(Student student);

    /**
     * To update an existing Student
     * @param student student
     * @return update result
     */
    boolean updateStudent(Student student);

    /**
     * To get a student by its id
     * @param studentId id of a student
     * @return Student
     */
    Student getById(String studentId);

    /**
     * To get all the Students
     * @return list of all students
     */
    List<Student> getAllStudents();

    /**
     * To delete a student by its id
     * @param studentId studentId
     * @return is it deleted
     */
    boolean deleteStudentById(String studentId);
}
