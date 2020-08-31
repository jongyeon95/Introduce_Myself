package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.BasicInformationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePortfolioServiceTest {

    @Autowired
    private UpdatePortfolioService portfolioService;

    @Test
    public void updateBasicInformation() {
        BasicInformationDto dto=new BasicInformationDto();
        dto.setIdx(3);
        dto.setAddress("test");
        dto.setAddress("test");

        assertThat(portfolioService.UpdateBasicInformation(dto)).isEqualTo(HttpStatus.BAD_REQUEST);

    }
}