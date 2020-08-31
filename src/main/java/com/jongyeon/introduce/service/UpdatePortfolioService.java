package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePortfolioService {

    @Autowired
    private BasicInformationRepository basicInformationRepository;

    public HttpStatus UpdateBasicInformation(BasicInformationDto basicInformationDto){
        Optional<BasicInformation> basicInformation=basicInformationRepository.findById(basicInformationDto.getIdx());
        if(!basicInformation.isPresent()){
            return HttpStatus.BAD_REQUEST;
        }
        basicInformation.get().setDto(basicInformationDto);
        basicInformationRepository.save(basicInformation.get());
        return HttpStatus.OK;

    }
}
