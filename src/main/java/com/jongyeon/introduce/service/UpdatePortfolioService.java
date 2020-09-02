package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.dto.SkillsDto;
import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Skills;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import com.jongyeon.introduce.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdatePortfolioService {

    @Autowired
    private BasicInformationRepository basicInformationRepository;
    @Autowired
    private SkillsRepository skillsRepository;

    public HttpStatus UpdateBasicInformation(BasicInformationDto basicInformationDto){
        Optional<BasicInformation> basicInformation=basicInformationRepository.findById(basicInformationDto.getIdx());
        if(!basicInformation.isPresent()){
            return HttpStatus.BAD_REQUEST;
        }
        basicInformation.get().setDto(basicInformationDto);
        basicInformationRepository.save(basicInformation.get());
        return HttpStatus.OK;
    }

    public HttpStatus UpdateSkills(SkillsDto skillsDto){
        Optional<Skills> skills=skillsRepository.findById(skillsDto.getIdx());
        if(!skills.isPresent()){
            return HttpStatus.BAD_REQUEST;
        }
        skills.get().setDto(skillsDto);
        skillsRepository.save(skills.get());
        return HttpStatus.OK;
    }

    public HttpStatus SaveSkills(SkillsDto skillsDto){
        Skills skills=new Skills().builder().name(skillsDto.getName()).createdTime(LocalDateTime.now()).updatedTime(LocalDateTime.now()).build();
        skillsRepository.save(skills);
        return HttpStatus.OK;
    }

    public HttpStatus DeleteSkills(Long id){
        Optional<Skills> skills=skillsRepository.findById(id);
        if(!skills.isPresent()){
            return HttpStatus.OK;
        }
        skillsRepository.delete(skills.get());
        return HttpStatus.OK;
    }
}
