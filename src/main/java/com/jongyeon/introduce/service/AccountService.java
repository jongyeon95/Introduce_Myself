package com.jongyeon.introduce.service;

import com.jongyeon.introduce.dto.AccountDto;
import com.jongyeon.introduce.entity.Account;
import com.jongyeon.introduce.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String username, String password)
    {
        log.info("Create New Account");
        Account account = new Account();
        account.setUserName(username);
        account.setPassword(passwordEncoder.encode(password));
        return accountRepository.save(account);
    }

    public boolean changeAccountInfo(AccountDto accountDto){

        if(passwordEncoder.matches(accountDto.getPw(),accountRepository.findById(accountDto.getIdx()).get().getPassword())) {
            log.info("password correct");
            Optional<Account> account;
            account = accountRepository.findById(accountDto.getIdx());
            account.get().setEmail(accountDto.getEmail());
            log.info(accountDto.getChagepw());

            if (!accountDto.getChagepw().equals("")) {
                log.info("change Admin password");
                account.get().setPassword(passwordEncoder.encode(accountDto.getChagepw()));
            }
            log.info("change Admin info");
            accountRepository.save(account.get());

            return true;
        }

            return false;
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUserName(username);
        if (!account.isPresent()) { throw new UsernameNotFoundException(username); }
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.get().getAuthority()));

        return new User(username, account.get().getPassword(), authorities);

    }

}
