package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.dto.CertificateDto;
import com.jongyeon.introduce.dto.SkillsDto;
import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Certificate;
import com.jongyeon.introduce.entity.Skills;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import com.jongyeon.introduce.repository.CertificateRepository;
import com.jongyeon.introduce.repository.SkillsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UpdatePortfolioService {

    @Autowired
    private BasicInformationRepository basicInformationRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private CertificateRepository certificateRepository;

    public HttpStatus UpdateBasicInformation(BasicInformationDto basicInformationDto){
        Optional<BasicInformation> basicInformation=basicInformationRepository.findById(basicInformationDto.getIdx());
        if(!basicInformation.isPresent()){
            log.info("fail update basicInformation because is null");
            return HttpStatus.BAD_REQUEST;
        }
        basicInformation.get().setDto(basicInformationDto);
        basicInformationRepository.save(basicInformation.get());
        log.info("Success update basicInformation");
        return HttpStatus.OK;
    }

    public HttpStatus UpdateSkills(SkillsDto skillsDto){
        Optional<Skills> skills=skillsRepository.findById(skillsDto.getIdx());
        if(!skills.isPresent()){
            log.info("fail update skills because is null");
            return HttpStatus.BAD_REQUEST;
        }
        skills.get().setDto(skillsDto);
        skillsRepository.save(skills.get());
        log.info("Success update skills");
        return HttpStatus.OK;
    }

    public HttpStatus SaveSkills(SkillsDto skillsDto){//todo null 예외처리 할것
        Skills skills=new Skills().builder().name(skillsDto.getName()).createdTime(LocalDateTime.now()).updatedTime(LocalDateTime.now()).build();
        skillsRepository.save(skills);
        log.info("Success add skills");
        return HttpStatus.OK;
    }

    public HttpStatus DeleteSkills(Long id){
        Optional<Skills> skills=skillsRepository.findById(id);
        if(!skills.isPresent()){
            log.info("Not Found delete skills");
            return HttpStatus.OK;
        }
        log.info("Success delete skills");
        skillsRepository.delete(skills.get());
        return HttpStatus.OK;
    }

    public HttpStatus SaveCertificate(CertificateDto certificateDto){
        Certificate certificate = new Certificate().builder()
                .name(certificateDto.getName())
                .takeTime(certificateDto.getTakeTime())
                .category(certificateDto.getCategory())
                .className(certificateDto.getClassName())
                .updatedTime(LocalDateTime.now())
                .createdTime(LocalDateTime.now())
                .issuingAgency(certificateDto.getIssuingAgency()).build();
        certificateRepository.save(certificate);
        return HttpStatus.OK;

    }

    public HttpStatus UpdateCertificate(CertificateDto certificateDto){
        Optional<Certificate> certificate=certificateRepository.findById(certificateDto.getIdx());
        if(!certificate.isPresent()){
            return HttpStatus.BAD_REQUEST;
        }
        certificate.get().setDto(certificateDto);
        certificateRepository.save(certificate.get());
        return HttpStatus.OK;
    }
}
