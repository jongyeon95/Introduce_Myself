package com.jongyeon.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String companyName;

    @Column(nullable=false)
    private String duty;

    @Column(nullable=false)
    private LocalDate startTime;

    private LocalDate endTime;


}
