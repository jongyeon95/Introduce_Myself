package com.jongyeon.introduce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String className;

    @Column(nullable=false)
    private  String issuingAgency;

    @Column(nullable=false)
    private String category;

    @Column(nullable=false)
    private LocalDate takeTime;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
