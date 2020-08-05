package com.jongyeon.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable=false)
    private String name;

    private String major;

    private String grade;

    @Column(nullable=false)
    private String status;

    private String gpa;

    @Column(nullable=false)
    private LocalDate startTime;

    private LocalDate endTime;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
