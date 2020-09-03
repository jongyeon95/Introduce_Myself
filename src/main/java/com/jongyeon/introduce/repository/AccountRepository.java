package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByUserName(String username);
    Optional<Account> findByAuthority(String auth);
    List<Account> findAllByAuthority(String auth);
}
