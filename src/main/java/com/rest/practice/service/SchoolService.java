package com.rest.practice.service;

import com.rest.practice.model.School;
import com.rest.practice.model.Student;
import com.rest.practice.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public void establishSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> schoolList() {
        return schoolRepository.findAll();
    }

    public School findSchool(String schoolName) {
        return schoolRepository.findSchoolBySchoolName(schoolName);
    };
}
