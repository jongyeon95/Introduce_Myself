package com.jongyeon.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String krName;

    @Column(nullable=false)
    private String engName;

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
