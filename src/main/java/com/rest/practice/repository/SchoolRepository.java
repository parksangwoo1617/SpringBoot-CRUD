package com.rest.practice.repository;

import com.rest.practice.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

    public School findSchoolBySchoolName(String schoolName);
}
