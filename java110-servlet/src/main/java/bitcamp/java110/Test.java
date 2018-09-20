package bitcamp.java110;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        String[] names = {
            "고정은", "권형은", "김영록",  "김종규",
            "김우제", "김현성", "김희정", "김민성",
            "여혜림", "오제하",
            "이광호", "이세영", 
            "이태형"  
        };
        
        String[] names2 = {
            //"국양훈", "이인진", "황무현", "안진호", "윤건희"
            //"서영준", "이용찬", "현경훈", "송서현", "최수정"
            "여혜림", "이세영", "이태형", "변종호", "홍길동"
        };
        
        ArrayList<String> list = new ArrayList<>();
        
        for (String name : names2) {
            list.add(name);
        }
        
        Scanner keyIn = new Scanner(System.in);
        
        while (list.size() > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.print(".");
                Thread.currentThread().sleep(200);
            }
            int no = (int)(Math.random() * list.size());
            System.out.println(list.remove(no));
            keyIn.nextLine();
        }
    }
}







