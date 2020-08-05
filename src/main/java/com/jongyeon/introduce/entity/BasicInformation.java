package com.jongyeon.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String email;

    private String profilePicture;

    @Column(nullable=false)
    private String content;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;




}
