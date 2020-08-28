package com.jongyeon.introduce;

import com.jongyeon.introduce.entity.Account;
import com.jongyeon.introduce.repository.AccountRepository;
import com.jongyeon.introduce.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class IntroduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntroduceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(AccountRepository accountRepository, AccountService accountService) throws Exception {
        return (args)->{
            if(accountRepository.findByUserName("Admin")==null){
            Account account= accountService.createAccount("Admin","Admin");
            account.setAuthority("ROLE_ADMIN");
            accountRepository.save(account);}

        };
    }

}
