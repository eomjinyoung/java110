package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController { 

    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list = App.managerDao.findAll();
        for (Manager s : list) {
            System.out.printf("%s, %s, %s, %s, %s\n",
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPosition());
        }
    }
    
}
