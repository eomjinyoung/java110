package bitcamp.java110.cms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java110.cms.domain.Student;

public interface StudentDao {
    int insert(Student student);
    List<Student> findAll(Map<String,Object> params);
    Student findByEmail(String email);
    Student findByNo(int no);
    int delete(int no);
    Student findByEmailPassword(Map<String,Object> params);
}








