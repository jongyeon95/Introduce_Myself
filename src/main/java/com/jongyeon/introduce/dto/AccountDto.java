package com.jongyeon.introduce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long idx;
    private String email;
    private String pw;
    private String chagepw;
}
