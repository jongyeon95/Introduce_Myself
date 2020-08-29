package com.jongyeon.introduce.service;

import com.jongyeon.introduce.repository.ViewCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitedCountService {
    @Autowired
    private ViewCountRepository viewCountRepository;

    public List<Integer> viewCount(){
        List<Integer> list=new ArrayList<>();
        Integer total=viewCountRepository.SumViewCount();
        Integer yesterDay= Math.toIntExact(viewCountRepository.findByDateIs(LocalDate.now().minusDays(1)).get().getTodayCnt());
        Integer today= Math.toIntExact(viewCountRepository.findByDateIs(LocalDate.now()).get().getTodayCnt());
        list.add(total);
        list.add(yesterDay);
        list.add(today);


        return list;
    }

}
