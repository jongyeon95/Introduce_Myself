package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Certificate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CertificateRepositoryTest {

    @Autowired
    private CertificateRepository certificateRepository;

    @Test
    public void findAllByCategoryIs() {
        List<Certificate> list=certificateRepository.findAllByCategoryIsOrderByTakeTime("자격");
        for(Certificate c : list){
            System.out.println(c.getName());
        }
    }
}