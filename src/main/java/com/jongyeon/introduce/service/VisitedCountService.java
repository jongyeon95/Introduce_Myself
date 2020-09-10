package com.jongyeon.introduce.service;

import com.jongyeon.introduce.repository.ViewCountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VisitedCountService {
    @Autowired
    private ViewCountRepository viewCountRepository;

    public List<Integer> viewCount(){

        List<Integer> list=new ArrayList<>();
        Integer total=viewCountRepository.SumViewCount();
        Integer yesterday;
        if (viewCountRepository.findByDateIs(LocalDate.now().minusDays(1)).isPresent()){
            yesterday= Math.toIntExact(viewCountRepository.findByDateIs(LocalDate.now().minusDays(1)).get().getTodayCnt());
        }
        else{
            yesterday=0;
        }

        Integer today= Math.toIntExact(viewCountRepository.findByDateIs(LocalDate.now()).get().getTodayCnt());
        list.add(total);
        list.add(yesterday);
        list.add(today);

        return list;
    }

}
