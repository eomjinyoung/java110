package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        for (int i = 0; i < App.teachers.size(); i++) {
            Teacher s = App.teachers.get(i);
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
}
