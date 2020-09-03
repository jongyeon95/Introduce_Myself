package com.jongyeon.introduce.controller;

import com.jongyeon.introduce.dto.AccountDto;
import com.jongyeon.introduce.entity.Account;
import com.jongyeon.introduce.repository.AccountRepository;
import com.jongyeon.introduce.service.AccountService;
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
public class AdminController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private VisitedCountService visitedCountService;
    @Autowired
    private AccountService accountService;


    @GetMapping("/admin/info")
    public String ShowAdminInfo(Model model){
        log.info("enter adminInfo");
        List<Integer> viewCountList=visitedCountService.viewCount();

        Optional<Account> account=accountRepository.findByAuthority("ROLE_ADMIN");
        if(account.get()==null){
            return "error";
        }
        System.out.println(account.get().getUserName());
        model.addAttribute("viewCnt",viewCountList);
        model.addAttribute("account",account);
        return "admin/adminInfo";
    }

    @GetMapping("/admin/update")
    public String ChangeAdminForm(Model model){
        log.info("enter Change Admin Info Form GetMapping");
        List<Integer> viewCountList=visitedCountService.viewCount();

        Optional<Account> account=accountRepository.findByAuthority("ROLE_ADMIN");
        if(account.get()==null){
            return "error";
        }

        System.out.println(account.get().getUserName());
        model.addAttribute("viewCnt",viewCountList);
        model.addAttribute("account",account);
        return "admin/adminInfoUpdate";
    }

    @ResponseBody
    @PutMapping("/admin/update/info")
    public HttpStatus UpdateAdmin(Model model, @RequestBody AccountDto accountDto){
        log.info("PutMapping changeInfo");
        log.info("accountDto data: "+accountDto);
        Optional<Account> account=accountRepository.findById(accountDto.getIdx());
        if(account.get()==null){
            return HttpStatus.BAD_REQUEST;
        }

        if(accountService.changeAccountInfo(accountDto)) {
            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }
}
