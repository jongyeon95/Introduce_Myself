package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career,Long> {
    List<Career> findAll();
}
