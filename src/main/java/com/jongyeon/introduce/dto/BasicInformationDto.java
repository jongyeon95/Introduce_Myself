package com.jongyeon.introduce.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicInformationDto {

    private long idx;

    private String kr;

    private String eng;

    private String address;

    private String email;

    private String content;

    private String github;

    private String blog;


}
