package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.dto.BasicInformationDto;
import com.jongyeon.introduce.dto.CertificateDto;
import com.jongyeon.introduce.dto.SkillsDto;
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

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/admin/update/skills/{id}")
    public String updateSkillsForm(Model model,@PathVariable Long id){
        Optional<Skills> s=portfolioService.findByIdSkills(id);
        List<Integer> viewCountList=visitedCountService.viewCount();


        model.addAttribute("skills",s);
        model.addAttribute("viewCnt",viewCountList);

        return "/admin/updateSkills";
    }

    @GetMapping("/admin/save/skills/")
    public String saveSkillsForm(Model model){
        Optional<Skills> s= Optional.of(new Skills());
        List<Integer> viewCountList=visitedCountService.viewCount();

        model.addAttribute("skills",s);
        model.addAttribute("viewCnt",viewCountList);

        return "/admin/updateSkills";
    }

    @ResponseBody
    @PutMapping("/admin/update/skills")
    public HttpStatus updateSkills(@RequestBody SkillsDto skillsDto){
        return updatePortfolioService.UpdateSkills(skillsDto);
    }

    @ResponseBody
    @PostMapping("/admin/save/skills")
    public HttpStatus saveSkills(@RequestBody SkillsDto skillsDto){
        return updatePortfolioService.SaveSkills(skillsDto);
    }



    @ResponseBody
    @DeleteMapping("/admin/delete/skills/{idx}")
    public HttpStatus deleteSkills(@PathVariable long idx){
        return updatePortfolioService.DeleteSkills(idx);
    }

    @GetMapping("/admin/save/certificate")
    public String saveCertificateForm(Model model){
        Optional<Certificate> c= Optional.of(new Certificate());

        List<Integer> viewCountList=visitedCountService.viewCount();


        model.addAttribute("viewCnt",viewCountList);
        model.addAttribute("certificate",c);
        return "admin/updateCertificate";


    }
    @ResponseBody
    @PostMapping("/admin/save/certificate")
    public HttpStatus saveCertificate(@RequestBody CertificateDto certificateDto){
        return updatePortfolioService.SaveCertificate(certificateDto);

    }

    @GetMapping("/admin/update/certificate/{id}")
    public String updateCertificateForm(Model model,@PathVariable Long id){
        Optional<Certificate> c= portfolioService.findByIdCertificate(id);
        List<Integer> viewCountList=visitedCountService.viewCount();

        model.addAttribute("viewCnt",viewCountList);
        model.addAttribute("certificate",c);
        return "admin/updateCertificate";

    }

    @ResponseBody
    @PutMapping("/admin/update/certificate")
    public HttpStatus updateCertificate(@RequestBody CertificateDto certificateDto){
        return updatePortfolioService.UpdateCertificate(certificateDto);
    }

    @ResponseBody
    @DeleteMapping("/admin/delete/certificate/{idx}")
    public HttpStatus deleteCertificate(@PathVariable Long idx){
        return updatePortfolioService.DeleteCertificate(idx);
    }




}
