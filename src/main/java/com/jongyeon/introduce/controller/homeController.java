package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.service.PortfolioService;
import com.jongyeon.introduce.service.VisitedCountService;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class homeController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private VisitedCountService visitedCountService;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        log.info("Enter the homepage");
        log.info("who is connect!:" +request.getRemoteAddr());
        portfolioService.ViewCountUp();


        List<Integer> viewCountList=visitedCountService.viewCount();

        model.addAttribute("viewCnt",viewCountList);

        return "home";

    }

}
