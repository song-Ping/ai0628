package com.example.minStudy.controller;

import com.example.minStudy.entity.Role;
import com.example.minStudy.repository.FreeBoardRepository;
import com.example.minStudy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String index(
//            Authentication authentication
    ) {
            roleRepository.save(new Role(1,"User"));
            roleRepository.save(new Role(2,"Admin"));
            roleRepository.save(new Role(3,"Manager"));
//        System.out.println("로그인 유무" + authentication.isAuthenticated());
//        System.out.println("getPrincipal" + authentication.getPrincipal());
//        System.out.println("userdetails" + authentication.getDetails());

        return "index";
    }

}
