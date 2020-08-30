package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.service.PortfolioService;
import com.jongyeon.introduce.service.VisitedCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UpdateController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private VisitedCountService visitedCountService;


    @GetMapping("/admin/update/basic")
    public String updateBasicForm(Model model){

        portfolioService.ViewCountUp();

        BasicInformation b=portfolioService.returnBasicInformation();
        List<Education> eList=portfolioService.returnEducationList();
        List<Certificate> ca = portfolioService.readCertificates("자격");
        List<Certificate> cb = portfolioService.readCertificates("어학");
        List<Certificate> cc = portfolioService.readCertificates("취득준비중");
        List<Skills> skills = portfolioService.readSkills();
        List<Career> careers =portfolioService.readCareers();
        List<Integer> viewCountList=visitedCountService.viewCount();



        model.addAttribute("certificateA",ca);
        model.addAttribute("certificateB",cb);
        model.addAttribute("certificateC",cc);
        model.addAttribute("basic",b);
        model.addAttribute("eduList",eList);
        model.addAttribute("skills",skills);
        model.addAttribute("careers",careers);
        model.addAttribute("viewCnt",viewCountList);
        return "/admin/updateBasicInformation";
    }
}
