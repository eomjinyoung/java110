package bitcamp.java110.cms.control;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class HelloController {

    @RequestMapping("hello")
    public void hello(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }


}
