package com.example.minStudy.service;

import com.example.minStudy.entity.Member;
import com.example.minStudy.entity.Role;
import com.example.minStudy.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("일로 오나" + username);
        Member member = memberRepository.findByUsername((username));
        System.out.println(member);
        if (member == null) {
            throw new UsernameNotFoundException("회원정보가 없습니다. 다시한번 아이디와 비밀번호를 확인해주세요.");
        }
        // spring security 시스템
        // 정부에서는 java spring개발 하는걸로 통일해라. => 전자정부 프레임워크
        // 스프링2.0부터 2000 -> 2023
        return User.builder()
                .username(username)
                .password(member.getPassword())
                .roles(new String[]{"USER",})
                .build();
    }

    public void save(Member member) {
        boolean result = validate(member);
        if (result) {
            //패스워드는 암호화 해서 저장
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            //롤을 적용해야 합니다.
            List<Role> list = Arrays.asList(new Role(1,"User"),new Role(2,"Admin"));
            member.setRoles(list);
            memberRepository.save(member);
        }
    }

    public boolean validate(Member member) {
        Member dbmember =
                memberRepository.findByUsername(member.getUsername());
        if (dbmember == null)
            return true;
        else
            throw new IllegalStateException("이미 가입된 회원입니다.");
    }
}