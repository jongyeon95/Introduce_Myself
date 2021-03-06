package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.CertificateDto;
import com.jongyeon.introduce.entity.Certificate;
import com.jongyeon.introduce.entity.Education;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioServiceTest {

    @Autowired
    private PortfolioService portfolioService;
    @Test
    public void returnEducationList() {
        List<Education> list= portfolioService.returnEducationList();
        for(Education e : list){
            System.out.println(e.getName());
        }
    }
    @Test
    public void updateBasicInfoTest(){
    }

    @Test
    public void insertCertificateTest(){
        CertificateDto certificateDto=new CertificateDto()
                .builder()
                .name("SQLD")
                .className("국가공인자격")
                .issuingAgency("과학기술정보통신부")
                .category("취득준비중")
                .build();
        portfolioService.insertCertificate(certificateDto);

    }
    
}