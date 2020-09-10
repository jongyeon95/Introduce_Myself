package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.CertificateDto;
import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PortfolioService {
    @Autowired
    private BasicInformationRepository basicInformationRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private CertificateRepository certificateRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private CareerRepository careerRepository;
    @Autowired
    private ViewCountRepository viewCountRepository;

    public BasicInformation returnBasicInformation(){
        BasicInformation b=basicInformationRepository.getOne(1L);
        return b;
    }

    public List<Education> returnEducationList(){
        List<Education> list= educationRepository.findAll();
        return list;
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

    public List<Certificate> readCertificates(String s){
        return certificateRepository.findAllByCategoryIsOrderByTakeTime(s);
    }
    public List<Certificate> readCertificatesAll(){
        return certificateRepository.findAllByOrderByTakeTime();
    }

    public List<Skills> readSkills(){
        return skillsRepository.findAll();
    }

    public Optional<Skills> findByIdSkills(Long id){return skillsRepository.findById(id);}

    public List<Career> readCareers(){return careerRepository.findAll();}

    public Optional<Certificate> findByIdCertificate(Long id){return certificateRepository.findById(id);}


    public void ViewCountUp(){
        LocalDate now =LocalDate.now();
        Optional<ViewCount> ld=viewCountRepository.findByDateIs(now);
        if(ld.isPresent()){
            ld.get().setTodayCnt(ld.get().getTodayCnt()+1);
            viewCountRepository.save(ld.get());

        }
        else{
            LocalDate localDate=LocalDate.now();
            ViewCount v= new ViewCount().builder().date(localDate).todayCnt(1L).build();
            viewCountRepository.save(v);

        }


    }



}
