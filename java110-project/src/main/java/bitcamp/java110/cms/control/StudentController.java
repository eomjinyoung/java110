package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {

    static Student[] students = new Student[5];
    static int studentIndex = 0;
    
    public static Scanner keyIn;
    
    static class Student extends Member {
        protected String school;
        protected boolean working;
        protected String tel;
        
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }
    
    
    public static void serviceStudentMenu() {
        while (true) {
            System.out.print("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();
            } else if (command.equals("add")) {
                inputStudents();
            } else if (command.equals("delete")) {
                deleteStudent();
            } else if (command.equals("detail")) {
                detailStudent();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private static void printStudents() {
        int count = 0;
        for (Student s : students) {
            if (count++ == studentIndex)
                break;
            System.out.printf("%d: %s, %s, %s, %s, %b, %s\n",
                    count - 1,
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
    
    private static void inputStudents() {
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
            
            
            if (studentIndex == students.length) {
                increaseStorage();
            }
            
            students[studentIndex++] = m;
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

    private static void increaseStorage() {
        Student[] newList = new Student[students.length + 3];
        for (int i = 0; i < students.length; i++) {
            newList[i] = students[i];
        }
        students = newList;
    }
    
    private static void deleteStudent() {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        for (int i = no; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        studentIndex--;
        
        System.out.println("삭제하였습니다.");
    }
    
    private static void detailStudent() {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", students[no].getName());
        System.out.printf("이메일: %s\n", students[no].getEmail());
        System.out.printf("암호: %s\n", students[no].getPassword());
        System.out.printf("최종학력: %s\n", students[no].getSchool());
        System.out.printf("전화: %s\n", students[no].getTel());
        System.out.printf("재직여부: %b\n", students[no].isWorking());
    }
    
    static {
        Student s = new Student();
        s.setName("a");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("b");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("c");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("d");
        students[studentIndex++] = s;
        
        s = new Student();
        s.setName("e");
        students[studentIndex++] = s;
    }
}






















