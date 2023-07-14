package com.example.minStudy.controller;

import com.example.minStudy.entity.FreeBoard;
import com.example.minStudy.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    FreeBoardRepository freeBoardRepository;
    @GetMapping("/")
    public String index(){
            FreeBoard f1 = new FreeBoard().builder()
                    .name("홍길동")
                    .content("내용")
                    .build();
        freeBoardRepository.save(f1);
        return "index";
    }

}
