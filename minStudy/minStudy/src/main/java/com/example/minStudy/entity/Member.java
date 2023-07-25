package com.example.minStudy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String username;
    private String password;

    private String email;
    private String age;
    private String gender;

    @ManyToMany
    @JoinTable(name = "member_role"
            , joinColumns = @JoinColumn(name = "member_idx")
            , inverseJoinColumns = @JoinColumn(name = "role_idx"))
    private List<Role> roles;// Role.java 파일에  @ManyToMany (mappedBy = "roles") private List<Member> member; 여기에 mappedBy 이름이랑 맞아야됨.

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)//멤버객체에 프리보드를 참조할꺼다
    private List<FreeBoard> boards = new ArrayList<>();

}
