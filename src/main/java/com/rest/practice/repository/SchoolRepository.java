package com.rest.practice.repository;

import com.rest.practice.model.School;
import com.rest.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    public School findSchoolBySchoolName(String schoolName);
}
