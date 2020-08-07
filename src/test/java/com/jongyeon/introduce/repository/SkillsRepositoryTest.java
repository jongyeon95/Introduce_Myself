package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Skills;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillsRepositoryTest {

    @Autowired
    private SkillsRepository skillsRepository;

    @Test
    public void saveTest(){
        skillsRepository.save(new Skills().builder()
                .name("Linux")
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build());
    }

}