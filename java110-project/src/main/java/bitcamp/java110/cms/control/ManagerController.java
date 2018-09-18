package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerController { 

    ManagerDao managerDao;
  
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    public void add(ServletRequest request, ServletResponse response) 
            throws Exception {
        Manager m = new Manager();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        PrintWriter out = response.getWriter();
        if (managerDao.insert(m) > 0) {
            out.println("저장하였습니다.");
        } else {
            out.println("같은 이메일의 매니저가 존재합니다.");
        }
    }
    
    @RequestMapping("manager/delete")
    public void delete(ServletRequest request, ServletResponse response) 
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if (managerDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("해당 번호의 매니저가 없습니다!");
        }
    }
    
    @RequestMapping("manager/detail")
    public void detail(ServletRequest request, ServletResponse response) 
            throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager m = managerDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if (m == null) {
            out.println("해당 번호의 매니저가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", m.getName());
        out.printf("이메일: %s\n", m.getEmail());
        out.printf("암호: %s\n", m.getPassword());
        out.printf("직위: %s\n", m.getPosition());
        out.printf("전화: %s\n", m.getTel());
    }
    
    @RequestMapping("manager/list")
    public void list(ServletRequest request, ServletResponse response) 
            throws Exception {
        PrintWriter out = response.getWriter();
        
        List<Manager> list = managerDao.findAll();
        for (Manager s : list) {
            out.printf("%d, %s, %s, %s\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getPosition());
        }
    }
}
    
    













    
    
    
    
    
    
    
