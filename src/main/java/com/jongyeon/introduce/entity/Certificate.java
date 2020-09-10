package com.jongyeon.introduce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String className;

    @Column(nullable=false)
    private  String issuingAgency;

    @Column(nullable=false)
    private String category;


    private LocalDate takeTime;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
