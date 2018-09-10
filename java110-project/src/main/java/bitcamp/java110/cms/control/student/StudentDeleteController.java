package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class StudentDeleteController {
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        App.students.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
}
