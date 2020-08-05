package com.jongyeon.introduce.service;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Education;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import com.jongyeon.introduce.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private BasicInformationRepository basicInformationRepository;
    @Autowired
    private EducationRepository educationRepository;

    public BasicInformation returnBasicInformation(){
        BasicInformation b=basicInformationRepository.getOne(1L);
        return b;
    }

    public List<Education> returnEducationList(){
        List<Education> list= educationRepository.findAll();
        return list;
    }

}
