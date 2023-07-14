package com.example.test0703.dto;

import lombok.*;

@Getter //@Data로 써도됨
@Setter
@ToString
@AllArgsConstructor
public class People {
    private int idx;
    private String name;
    private int age;
}
