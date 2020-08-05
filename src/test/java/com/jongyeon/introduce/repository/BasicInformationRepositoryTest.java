package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.BasicInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicInformationRepositoryTest {

    @Autowired
    BasicInformationRepository basicInformationRepository;

    @Test
    public void Save(){
        String name="박종연";
        String address="서울특별시 성북구 삼선동";
        String email="whddus9509@naver.com";
        String content="업로드 테스트";
        LocalDateTime createdTime=LocalDateTime.now();
        basicInformationRepository.save(new BasicInformation().builder()
                .name(name)
                .address(address)
                .content(content)
                .email(email)
                .createdTime(createdTime)
                .build());

    }


}