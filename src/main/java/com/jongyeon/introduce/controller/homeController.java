package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class homeController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String home(Model model){
        BasicInformation b=portfolioService.returnBasicInformation();
        model.addAttribute("basic",b);

        return "home";

    }

}
