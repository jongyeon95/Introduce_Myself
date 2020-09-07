package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class InfoController {
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/basic")
    public String returnBasicInformationView(Model model){
        log.info("return BasicInformation");
        BasicInformation b=portfolioService.returnBasicInformation();
        model.addAttribute("basic",b);
        return "info/basicInformation";
    }

    @GetMapping("/certificates")
    public String returnCertificateView(Model model){
        log.info("return Certificate");
        List<Certificate> c=portfolioService.readCertificatesAll();
        model.addAttribute("certificate",c);
        return "info/certificates";
    }

    @GetMapping("/education")
    public String returnEducationView(Model model){
        log.info("return Education");
        List<Education> e=portfolioService.returnEducationList();
        model.addAttribute("education",e);
        return "info/education";
    }

    @GetMapping("/skills")
    public String returnSkillsView(Model model){
        log.info("return Skills");
        List<Skills> s=portfolioService.readSkills();
        model.addAttribute("skills",s);
        return "info/skills";
    }

    @GetMapping("/careers")
    public String returnCareerView(Model model){
        log.info("return careers");
        List<Career> c=portfolioService.readCareers();
        model.addAttribute("career",c);
        return "info/careers";
    }
}
