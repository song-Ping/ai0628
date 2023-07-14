package com.example.test0703.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int idx;
    private String content;
}
