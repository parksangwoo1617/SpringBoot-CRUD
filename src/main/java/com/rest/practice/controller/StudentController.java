package com.rest.practice.controller;

import com.rest.practice.dto.StudentDto;
import com.rest.practice.model.Student;
import com.rest.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/studentList")
    public List<StudentDto> studentList() {
        return studentService.studentList();
    }

    @GetMapping("/student")
    public List<StudentDto> studentListBySchool(@ModelAttribute("school") String school) {
        return studentService.studentListBySchool(school);
    }

    @PostMapping("/student/enroll")
    public void studentEnrollment(@RequestBody StudentDto student) {
        studentService.enrollmentStudent(student);
    }
}
