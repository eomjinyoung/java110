package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentListController {

    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        for (int i = 0; i < App.students.size(); i++) {
            Student s = App.students.get(i);
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
}
