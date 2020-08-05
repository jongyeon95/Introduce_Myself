package com.jongyeon.introduce.service;

import com.jongyeon.introduce.entity.Education;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}