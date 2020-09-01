package com.jongyeon.introduce.entity;

import com.jongyeon.introduce.dto.SkillsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public void setDto(SkillsDto dto){
        this.id=dto.getIdx();
        this.name=dto.getName();
        this.updatedTime=LocalDateTime.now();

    }
}
