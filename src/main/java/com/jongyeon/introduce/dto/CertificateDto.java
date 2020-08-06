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

    @NotNull
    private String name;

    @NotNull
    private String className;

    @NotNull
    private String category;

    @NotNull
    private  String issuingAgency;

    @NotNull
    private LocalDate takeTime;
}
