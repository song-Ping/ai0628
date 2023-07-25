package com.example.minStudy.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FreeBoard extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idx;

    private String name;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;
}
