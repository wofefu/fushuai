package com.example.demo.entity.Lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LomBok {
    private String username;
    private String password;

    public static void main(String[] args) {
        LomBok lomBok=new LomBok("fushuai","password");
    }
}
