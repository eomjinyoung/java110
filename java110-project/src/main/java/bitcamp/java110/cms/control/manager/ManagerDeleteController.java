package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;

@Component
public class ManagerDeleteController { 

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 매니저의 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (managerDao.delete(no) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("해당 번호의 매니저가 없습니다!");
        }
    }
    
}
