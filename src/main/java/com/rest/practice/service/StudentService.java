package com.rest.practice.service;

import com.rest.practice.dto.StudentDto;
import com.rest.practice.model.School;
import com.rest.practice.model.Student;
import com.rest.practice.repository.SchoolRepository;
import com.rest.practice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolService schoolService;

    public void enrollmentStudent(StudentDto student) {
        School school = schoolService.findSchool(student.getSchool());
        Student students = new Student(student.getName(), school);
        studentRepository.save(students);
    }

    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    public List<Student> studentListBySchool(String school) {
        return studentRepository.findAllBySchoolName(school);
    }
}
