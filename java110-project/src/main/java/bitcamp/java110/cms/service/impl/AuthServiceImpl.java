package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired MemberDao memberDao;
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
            String accessToken, String type) {
        
        // Facebook의 Graph API 실행하기
        // => HTTP 요청을 할 때 스프링에서 제공하는 RestTemplate을 사용하라! 
        // 
        RestTemplate restTemplate = new RestTemplate();
        
        /*
        HashMap<String,String> vars = new HashMap<>();
        vars.put("v1", accessToken);
        vars.put("v2", "id,name,email");
        */
        
        // 원격 서버에서 보낸 JSON 문자열을 Map 객체로 자동 변환하려면
        // JSON 문자열을 처리하는 라이브러리를 추가해 둬야 한다.
        // 따로 코드를 추가할 필요는 없다.
        // => Gson 또는 Jackson 라이브러리
        //
        @SuppressWarnings("rawtypes")
        Map response = restTemplate.getForObject(
            "https://graph.facebook.com/v3.2/me?access_token={v1}&fields={v2}", 
            Map.class,
            accessToken,
            "id,name,email");
            //vars); // 값을 개별적으로 넘기지 않고 맵에 담아 넘길 수도 있다.
      
        // Facebook 사용자의 이메일로 현재 서버의 사용자 정보를 찾는다.
        Member member = null;
        if (type.equals("manager")) {
            member = managerDao.findByEmail(response.get("email").toString());
        } else if (type.equals("student")) {
            member = studentDao.findByEmail(response.get("email").toString());
        } else if (type.equals("teacher")) {
            member = teacherDao.findByEmail(response.get("email").toString());
        }
        
        // 해당 회원을 현재 서버에서 찾았으면 그 정보를 리턴한다.
        if (member != null)
          return member;
        
        // 현재 서버에 가입한 사용자가 아니라면, 
        // 페이스북 기본 정보를 가지고 자동으로 회원 등록한다.
        //
        
        Member newbie = createMember(type, 
            response.get("name").toString(),
            response.get("email").toString(),
            "1111");
        
        memberDao.insert(newbie);
        
        if (type.equals("manager")) {
          ((Manager)newbie).setPosition("미정");
          
          managerDao.insert((Manager)newbie);
          
        } else if (type.equals("student")) {
          ((Student)newbie).setSchool("미정");
          ((Student)newbie).setWorking(false);
          studentDao.insert((Student)newbie);
          
        } else if (type.equals("teacher")) {
          ((Teacher)newbie).setPay(0);
          ((Teacher)newbie).setSubjects("미정");
          teacherDao.insert((Teacher)newbie);
        }
        
        return newbie;
    }
    
    private Member createMember(
        String memberType, String name, String email, String password) {
      Member member = null;
      
      if (memberType.equals("manager")) {
        member = new Manager();
      } else if (memberType.equals("student")) {
        member = new Student();
      } else if (memberType.equals("teacher")) {
        member = new Teacher();
      }
      
      member.setEmail(email);
      member.setName(name);
      member.setPassword(password);
      
      return member;
    }
    
}










