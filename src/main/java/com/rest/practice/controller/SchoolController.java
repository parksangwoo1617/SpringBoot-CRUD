package com.rest.practice.controller;

import com.rest.practice.dto.SchoolResponse;
import com.rest.practice.model.School;
import com.rest.practice.model.Student;
import com.rest.practice.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/school")
    public List<SchoolResponse> schoolList() {
        List<SchoolResponse> schools = schoolService.schoolList();
        return schools;
    }

    @PostMapping("/schoolEstablish")
    public void schoolEstablish(@RequestBody School school) {
        schoolService.establishSchool(school);
    }
}
