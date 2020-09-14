package com.jongyeon.introduce.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {

    private Long idx;

    private String name;

    private String className;

    private String category;

    private  String issuingAgency;

    private LocalDate takeTime;
}
