package com.rest.practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.practice.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolResponse {
    private String schoolName;

    private LocalDateTime createdDate;
}
