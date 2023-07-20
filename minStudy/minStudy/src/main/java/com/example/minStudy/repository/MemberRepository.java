package com.example.minStudy.repository;

import com.example.minStudy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {

    // select * from where username = ?1 이 생성됩니다.
    public Member findByUsername(String username);
}