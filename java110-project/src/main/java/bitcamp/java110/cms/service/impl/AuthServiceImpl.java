package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired ManagerDao managerDao;
    @Autowired TeacherDao teacherDao;
    @Autowired StudentDao studentDao;
  

    @Override
    public Member getMember(
            String email, String password, String memberType) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        if (memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);
            
        } else if (memberType.equals("student")) {
            return studentDao.findByEmailPassword(params);
            
        } else if (memberType.equals("teacher")) {
            return teacherDao.findByEmailPassword(params);
            
        } else {
            return null;
        }
    }
    
    @Override
    public Member getFacebookMember(
            String accessToken, String memberType) {
        
        // Facebook의 Graph API 실행하기
        // => HTTP 요청을 할 때 스프링에서 제공하는 RestTemplate을 사용하라! 
        // 
        RestTemplate restTemplate = new RestTemplate();
        
        Map responseMap = restTemplate.getForObject(
            "https://graph.facebook.com/v3.2/me?access_token={v1}&fields={v2}", 
            Map.class,
            accessToken, 
            "id,name,email");
      
        System.out.println(responseMap);
        return null;
        
        //HashMap<String,Object> params = new HashMap<>();
        //params.put("email", email);
        //params.put("password", password);
        /*
        if (memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);
            
        } else if (memberType.equals("student")) {
            return studentDao.findByEmailPassword(params);
            
        } else if (memberType.equals("teacher")) {
            return teacherDao.findByEmailPassword(params);
            
        } else {
            return null;
        }
        */
    }
    
}










