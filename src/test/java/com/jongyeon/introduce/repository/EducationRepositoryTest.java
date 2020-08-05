package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Education;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EducationRepositoryTest {
    @Autowired
    private EducationRepository educationRepository;

    @Test
    public void Save(){
        String name="한성대학교";
        String status="졸업 예정";
        String grade="학사";
        String gpa="3.97";
        String major="정보시스템공학과";
        LocalDate startTime= LocalDate.of(2014,3,2);
        LocalDate endTime= LocalDate.of(2014,2,28);
        LocalDateTime createdTime=LocalDateTime.now();
        educationRepository.save(new Education().builder()
                .name(name)
                .status(status)
                .startTime(startTime)
                .gpa(gpa)
                .grade(grade)
                .major(major)
                .createdTime(createdTime)
                .build());

    }

}