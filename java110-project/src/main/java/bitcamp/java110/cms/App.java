package bitcamp.java110.cms;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
    
    public static void main(String[] args) throws Exception {
        Thread main = Thread.currentThread();
        //System.out.println(main.getName());
        
        ThreadGroup mainGroup = main.getThreadGroup();
        //System.out.println(mainGroup.getName());
        
        ThreadGroup systemGroup = mainGroup.getParent();
        System.out.println(systemGroup.getName());
        
        
        System.out.println("[스레드]");
        Thread[] threads = new Thread[20];
        int count = systemGroup.enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            System.out.println(threads[i].getName());
        }
        
        System.out.println("[스레드 그룹]");
        ThreadGroup[] tgs = new ThreadGroup[20];
        count = systemGroup.enumerate(tgs, false);
        for (int i = 0; i < count; i++) {
            System.out.println(tgs[i].getName());
        }
        
        System.out.println("[main 그룹의 스레드]");
        count = mainGroup.enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            System.out.println(threads[i].getName());
        }
        
        System.out.println("[Inno~ 그룹의 스레드]");
        count = tgs[1].enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            System.out.println(threads[i].getName());
        }
        
    }

}






















