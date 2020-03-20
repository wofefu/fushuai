package com.kd27.ssm1.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String address;
}
