package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.BasicInformation;
import com.jongyeon.introduce.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
    @Autowired
    private PortfolioService portfolioService;
    @GetMapping("/test")
    public String test(Model model){
        BasicInformation b=portfolioService.returnBasicInformation();
        model.addAttribute("basic",b);
        return "test2";

    }
}
