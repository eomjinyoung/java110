package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 학생의 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (studentDao.delete(no) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("번호에 해당하는 학생이 없습니다.");
        }
    }
}
