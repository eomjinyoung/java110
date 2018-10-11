package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherService {
    void add(Teacher teacher);
    List<Teacher> list();
    Teacher get(int no);
    void delete(int no);
}
