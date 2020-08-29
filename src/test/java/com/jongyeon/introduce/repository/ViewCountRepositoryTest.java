package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.service.VisitedCountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewCountRepositoryTest {

    @Autowired
    private ViewCountRepository viewCountRepository;

    @Autowired
    private VisitedCountService visitedCountService;

    @Test
    public void sumViewCount() {
        Integer a=viewCountRepository.SumViewCount();
        System.out.println(a);
        List<Integer> list=visitedCountService.viewCount();
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}