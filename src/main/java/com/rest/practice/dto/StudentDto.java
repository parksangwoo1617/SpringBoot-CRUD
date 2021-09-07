package com.rest.practice.dto;

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
}
