package com.rest.practice.repository;

import com.rest.practice.dto.StudentDto;
import com.rest.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional(readOnly = true)
    @Query("select s from Student s where s.school.schoolName = :school")
    List<StudentDto> findAllBySchoolName(@Param("school") String school);
}
