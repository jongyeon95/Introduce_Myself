package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.CertificateDto;
import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Certificate;
import com.jongyeon.introduce.entity.Education;
import com.jongyeon.introduce.repository.BasicInformationRepository;
import com.jongyeon.introduce.repository.CertificateRepository;
import com.jongyeon.introduce.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private BasicInformationRepository basicInformationRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private CertificateRepository certificateRepository;

    public BasicInformation returnBasicInformation(){
        BasicInformation b=basicInformationRepository.getOne(1L);
        return b;
    }

    public List<Education> returnEducationList(){
        List<Education> list= educationRepository.findAll();
        return list;
    }

    public void updateBasicInformation(Long id) {
        //todo 받아올거 생각하기
        Optional<BasicInformation> b = basicInformationRepository.findById(id);
        if(!b.isPresent())
            return;
        b.get().setContent("업데이트 되나?");
        basicInformationRepository.save(b.get());

    }

    public void insertCertificate(CertificateDto c){
        Certificate certificate=new Certificate().builder()
                .name(c.getName())
                .issuingAgency(c.getIssuingAgency())
                .className(c.getClassName())
                .createdTime(LocalDateTime.now())
                .takeTime(c.getTakeTime())
                .category(c.getCategory())
                .updatedTime(LocalDateTime.now())
                .build();
        certificateRepository.save(certificate);
    }



}
