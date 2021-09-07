package com.rest.practice.service;

import com.rest.practice.dto.SchoolResponse;
import com.rest.practice.model.School;
import com.rest.practice.model.Student;
import com.rest.practice.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Transactional
    public void establishSchool(School school) {
        schoolRepository.save(school);
    }

    @Transactional
    public List<SchoolResponse> schoolList() {
        return schoolRepository.findAll()
                .stream().map(school -> SchoolResponse.builder()
                        .createdDate(school.getCreatedDate())
                        .schoolName(school.getSchoolName())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public School findSchool(String schoolName) {
        return schoolRepository.findSchoolBySchoolName(schoolName);
    };
}
