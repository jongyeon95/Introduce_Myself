package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.entity.*;
import com.jongyeon.introduce.service.PortfolioService;
import com.jongyeon.introduce.service.UpdatePortfolioService;
import com.jongyeon.introduce.service.VisitedCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class UpdateController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private VisitedCountService visitedCountService;
    @Autowired
    private UpdatePortfolioService updatePortfolioService;


    @GetMapping("/admin/update/basic")
    public String updateBasicForm(Model model){

        BasicInformation b=portfolioService.returnBasicInformation();
        List<Integer> viewCountList=visitedCountService.viewCount();


        model.addAttribute("basic",b);
        model.addAttribute("viewCnt",viewCountList);

        return "/admin/updateBasicInformation";
    }


    @ResponseBody
    @PutMapping("/admin/update/basic")
    public HttpStatus updateBasicInformation(@RequestBody BasicInformationDto basicInformationDto){

        return updatePortfolioService.UpdateBasicInformation(basicInformationDto);
    }

}
