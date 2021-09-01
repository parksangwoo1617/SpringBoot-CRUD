package com.rest.practice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)  // 지연 로딩
    @JoinColumn(name = "school_name")
    private School school;

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }
}
