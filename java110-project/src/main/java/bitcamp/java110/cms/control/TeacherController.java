package bitcamp.java110.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherController {
    
    private List<Teacher> teachers = new ArrayList<>();
    
    @RequestMapping("teacher")
    public void teacher(Scanner keyIn) {
        while (true) {
            System.out.print("강사 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            } else if (command.equals("add")) {
                inputTeachers(keyIn);
            } else if (command.equals("delete")) {
                deleteTeacher(keyIn);
            } else if (command.equals("detail")) {
                detailTeacher(keyIn);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher s = teachers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                    i,
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPay(),
                    s.getSubjects());
        }
    }
    
    private void inputTeachers(Scanner keyIn) {
        while (true) {
            Teacher m = new Teacher();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의과목?(예: 자바,C,C++) ");
            m.setSubjects(keyIn.nextLine());
            
            teachers.add(m);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private void deleteTeacher(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        teachers.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private void detailTeacher(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher t = teachers.get(no);
        
        System.out.printf("이름: %s\n", t.getName());
        System.out.printf("이메일: %s\n", t.getEmail());
        System.out.printf("암호: %s\n", t.getPassword());
        System.out.printf("전화: %s\n", t.getTel());
        System.out.printf("시급: %d\n", t.getPay());
        System.out.printf("강의과목: %s\n", t.getSubjects());
    }
}
