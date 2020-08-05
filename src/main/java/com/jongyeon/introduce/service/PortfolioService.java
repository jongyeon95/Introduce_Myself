package com.jongyeon.introduce.service;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private BasicInformationRepository basicInformationRepository;

    public BasicInformation returnBasicInformation(){
        BasicInformation b=basicInformationRepository.getOne(1L);
        return b;
    }

}
