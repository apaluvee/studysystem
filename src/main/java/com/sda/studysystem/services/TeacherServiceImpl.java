package com.sda.studysystem.services;

import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of TeacherService
 * @author Alar
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public boolean createTeacher(Teacher teacher) {
        if (teacher == null) {
            return false;
        }
        teacherRepository.save(teacher);
        return true;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        if (teacher == null || !teacherRepository.existsById(teacher.getId())) {
            return false;
        }
        teacherRepository.saveAndFlush(teacher);
        return true;

    }

    @Override
    public Teacher getById(Long teacherId) {
        return teacherRepository.getOne(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public boolean deleteTeacherById(Long teacherId) {
        if(teacherId == null || !teacherRepository.existsById(teacherId)) {
            return false;
        }
        teacherRepository.deleteById(teacherId);
        return false;
    }
}
