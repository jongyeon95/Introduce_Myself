package com.jongyeon.introduce.repository;

import com.jongyeon.introduce.entity.ViewCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ViewCountRepository extends JpaRepository<ViewCount, Long> {

    Optional<ViewCount> findByDateIs(LocalDate localDate);

    @Query("SELECT SUM(todayCnt) FROM ViewCount")
    Integer SumViewCount();

}
