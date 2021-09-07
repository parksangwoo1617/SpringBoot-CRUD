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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolService schoolService;

    @Transactional
    public void enrollmentStudent(StudentDto student) {
        School school = schoolService.findSchool(student.getSchool());
        Student students = new Student(student.getName(), school);
        studentRepository.save(students);
    }

    @Transactional
    public List<StudentDto> studentList() {
        return studentRepository.findAll()
                .stream().map(student -> StudentDto.builder()
                    .name(student.getName())
                    .createdDate(student.getCreatedDate())
                    .school(student.getSchool().getSchoolName())
                    .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public List<StudentDto> studentListBySchool(String school) {
        return studentRepository.findAllBySchoolName(school);
    }
}
