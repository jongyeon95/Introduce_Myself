package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Certificate;
import com.jongyeon.introduce.entity.Education;
import com.jongyeon.introduce.service.PortfolioService;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class homeController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        log.info("homepage");
        log.info("who is connect!:" +request.getRemoteAddr());
        BasicInformation b=portfolioService.returnBasicInformation();
        List<Education> eList=portfolioService.returnEducationList();
        List<Certificate> ca = portfolioService.readCertificates("자격");
        List<Certificate> cb = portfolioService.readCertificates("어학");
        model.addAttribute("certificateA",ca);
        model.addAttribute("certificateB",cb);
        model.addAttribute("basic",b);
        model.addAttribute("eduList",eList);

        return "home";

    }

}
