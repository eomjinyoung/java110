package bitcamp.java110.cms.control;

import java.util.Scanner;

public class PlusController implements Controller {

    public String name = "plus";
        
    @Override
    public void service(Scanner keyIn) {
        System.out.print("a? ");
        int a = Integer.parseInt(keyIn.nextLine());
        
        System.out.print("b? ");
        int b = Integer.parseInt(keyIn.nextLine());
        
        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }


}
