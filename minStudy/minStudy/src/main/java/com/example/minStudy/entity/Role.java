package com.example.minStudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    // 자동증가하는 컬럼 기본키가 됨
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;    //primary key

    //User, Admin, Manager
    private String name;

    public Role(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    //EAGER = left join 바로 하기 때문에 조회할때 데이터를 더 많이 조회해야하고
    //LAZY = 필요할때 select구문을 한번더 실행하기떄문에 자원을 한꺼번에 많이 먹는 것은 EAGER
    //자원을 천천히 먹게되는 것은 LAZY
    @ManyToMany(mappedBy = "roles" ,fetch = FetchType.LAZY)
    private List<Member> members;

}