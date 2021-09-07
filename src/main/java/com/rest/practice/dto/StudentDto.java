package com.rest.practice.dto;

import com.rest.practice.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class StudentDto {

    private String name;
    private String school;
    private LocalDateTime createdDate;

    public StudentDto(Student student) {
        this.name = student.getName();
        this.school = student.getSchool().getSchoolName();
        this.createdDate = student.getCreatedDate();
    }

}
