package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;

@Component("4")
public class HelloController implements Controller {

    @Override
    public void service(Scanner keyIn) {
        System.out.println("안녕하세요!!!");
        
    }


}
