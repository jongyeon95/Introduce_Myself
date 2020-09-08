package com.jongyeon.introduce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class LoginFailService implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String account = (String)event.getAuthentication().getPrincipal();
        String password = (String)event.getAuthentication().getCredentials();
        log.info("Login Fail");
        log.info("account: "+account);
        log.info("password: "+password);
        log.info("Request Ip: "+req.getRemoteAddr());


    }
}
