package com.example.demo2.conf;

import com.example.demo2.obj.AA;
import com.example.demo2.obj.BB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//개발환경 설정
@Configuration
public class MyConfiguration {

    @Bean
    public AA aa(){
        return new AA("존");
    }

    @Bean   //bean을 써놓으면 객체를 주입할 수 있따.
    public BB bb(){
        return new BB();
    }
}
