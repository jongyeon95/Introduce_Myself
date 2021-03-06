package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {
    List<Certificate> findAllByCategoryIsOrderByTakeTime(String s);
    List<Certificate> findAllByOrderByTakeTime();
}
