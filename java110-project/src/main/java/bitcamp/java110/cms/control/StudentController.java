package bitcamp.java110.cms.control;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;

public class StudentController implements Controller {

    private List<Student> students;
    
    public StudentController(List<Student> students) {
        this.students = students;
        init();
    }
    
    public void service(Scanner keyIn) {
        while (true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if (command.equals("add")) {
                inputStudents(keyIn);
            } else if (command.equals("delete")) {
                deleteStudent(keyIn);
            } else if (command.equals("detail")) {
                detailStudent(keyIn);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    i,
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
    
    private void inputStudents(Scanner keyIn) {
        while (true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            students.add(m);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private void deleteStudent(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        students.remove(no);
        
        System.out.println("삭제하였습니다.");
    }
    
    private void detailStudent(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Student student = students.get(no);
        
        System.out.printf("이름: %s\n", student.getName());
        System.out.printf("이메일: %s\n", student.getEmail());
        System.out.printf("암호: %s\n", student.getPassword());
        System.out.printf("최종학력: %s\n", student.getSchool());
        System.out.printf("전화: %s\n", student.getTel());
        System.out.printf("재직여부: %b\n", student.isWorking());
    }
    
    private void init() {
        Student s = new Student();
        s.setName("a");
        students.add(s);
        
        s = new Student();
        s.setName("b");
        students.add(s);
        
        s = new Student();
        s.setName("c");
        students.add(s);
        
        s = new Student();
        s.setName("d");
        students.add(s);
        
        s = new Student();
        s.setName("e");
        students.add(s);
    }
}






















