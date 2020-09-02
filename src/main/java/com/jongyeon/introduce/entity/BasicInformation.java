package com.jongyeon.introduce.entity;

import com.jongyeon.introduce.dto.BasicInformationDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private String githubUrl;

    private String blogUrl;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;


    public void setDto(BasicInformationDto dto){

        this.krName=dto.getKr();
        this.engName=dto.getEng();
        this.address=dto.getAddress();
        this.email=dto.getEmail();
        this.content=dto.getContent();
        this.updatedTime=LocalDateTime.now();
        this.githubUrl=dto.getGithub();
        this.blogUrl=dto.getBlog();
    }


}
