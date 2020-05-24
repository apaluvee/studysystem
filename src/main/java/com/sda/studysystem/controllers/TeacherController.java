package com.sda.studysystem.controllers;

import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Teacher operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> showAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(Teacher teacher) {
        teacherService.createTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long teacherId, Teacher teacher) {
        teacher.setTeacherId(teacherId);
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long teacherId) {
        teacherService.deleteTeacherById(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreTeacher(@PathVariable("id") Long teacherId) {
        teacherService.restoreTeacherById(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
