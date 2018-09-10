package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= App.teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher t = App.teachers.get(no);
        
        System.out.printf("이름: %s\n", t.getName());
        System.out.printf("이메일: %s\n", t.getEmail());
        System.out.printf("암호: %s\n", t.getPassword());
        System.out.printf("전화: %s\n", t.getTel());
        System.out.printf("시급: %d\n", t.getPay());
        System.out.printf("강의과목: %s\n", t.getSubjects());
    }
}
