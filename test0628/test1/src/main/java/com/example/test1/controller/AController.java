package com.example.test1.controller;

import com.example.test1.myclass.AA;
import com.example.test1.myclass.BB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    @Autowired
    AA aa3;

    @Autowired
    AA aa4;

    @Autowired
    BB bb3;

    @Autowired
    BB bb4;
    @GetMapping("aa")
    public String aa(){
        AA aa1 = new AA();
        AA aa2 = new AA();
        System.out.println("aa1 = " + aa1);
        System.out.println("aa2 = " + aa2);

        System.out.println("aa3 = " + aa3);
        System.out.println("aa4 = " + aa4);

        System.out.println("aa1.a = " + aa1.a);
        System.out.println("aa2.a = " + aa2.a);

        aa1.a = 20;

        System.out.println("aa1.a = " + aa1.a);
        System.out.println("aa2.a = " + aa2.a);

        aa1.a = 40;
        System.out.println("aa3.a = " + aa3.a);
        System.out.println("aa4.a = " + aa4.a);

        return "quequeque";
    }

    @GetMapping("bb")
    public String bb(){

        BB bb1 = new BB();
        BB bb2 = new BB();

        System.out.println("bb1 = " + bb1);
        System.out.println("bb2 = " + bb2);


        bb1.a = 32;

        System.out.println("bb1 = " + bb1.a);
        System.out.println("bb2 = " + bb2.a);

        bb3.a = 50;

        System.out.println("bb3 = " + bb3.a);
        System.out.println("bb4 = " + bb4.a);

        return "bb";
    }
}
