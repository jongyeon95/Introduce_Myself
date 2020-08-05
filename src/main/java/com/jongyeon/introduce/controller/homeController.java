package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.entity.Education;
import com.jongyeon.introduce.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class homeController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String home(Model model){
        BasicInformation b=portfolioService.returnBasicInformation();
        List<Education> eList=portfolioService.returnEducationList();
        model.addAttribute("basic",b);
        model.addAttribute("eduList",eList);

        return "home";

    }

}
