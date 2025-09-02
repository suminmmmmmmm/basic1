package com.example.base1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private int count;

    public HomeController() {
        count = -1;
    }
     @GetMapping("/home/main")
     @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome() {
         return "안녕하세요";
     }


    @GetMapping("/home/main2")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome2() {
        return "환영합니다";
    }

    @GetMapping("/home/main3")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showHome3() {
        return "스프링부트는 획기적이다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody //아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public int increase() {

         count++;
        return count;
    }
    
}
