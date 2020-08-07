package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills,Long> {
    List<Skills> findAll();
}
