package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.service.PortfolioService;
import com.jongyeon.introduce.service.VisitedCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class UpdateController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private VisitedCountService visitedCountService;


    @GetMapping("/admin/update/basic")
    public String updateBasicForm(Model model){

        BasicInformation b=portfolioService.returnBasicInformation();
        List<Integer> viewCountList=visitedCountService.viewCount();


        model.addAttribute("basic",b);
        model.addAttribute("viewCnt",viewCountList);

        return "/admin/updateBasicInformation";
    }


    @PostMapping("/admin/update/basic")//put으로 바꿀것
    public String updateBasicInformation(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getParameter("krName"));
        return "redirect:/";
    }

}
