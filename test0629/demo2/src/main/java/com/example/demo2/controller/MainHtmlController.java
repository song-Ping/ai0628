package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHtmlController {

    @GetMapping("aa")
    public String aa(Model model, String num1, String num2, String num3) {
        System.out.println("출력");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

        if(num1 == null) {
            num1 = "0";
        }
        if(num2 == null) {
            num2 = "0";
        }
        if(num3 == null) {
            num3 = "0";
        }

        if(num2.equals("+")){
            model.addAttribute("result", Integer.parseInt(num1) + Integer.parseInt(num3));
        }else if(num2.equals("-")){
            model.addAttribute("result", Integer.parseInt(num1) - Integer.parseInt(num3));
        }else if(num2.equals("*") || num2.equals("x") || num2.equals("X")){
            model.addAttribute("result", Integer.parseInt(num1) * Integer.parseInt(num3));
        }else {
            model.addAttribute("result", Integer.parseInt(num1) / Integer.parseInt(num3));
        }

        model.addAttribute("data", "asdfasdf");
//        model.addAttribute("result", Integer.parseInt(num1) + Integer.parseInt(num3));
        return "aa";
    }
}
