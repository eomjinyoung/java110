package bitcamp.java110.cms.control.student;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentListController {

    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        List<Student> list = App.studentDao.findAll();
        
        for (Student s : list) {
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel());
        }
    }
}
