package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    int insert(Manager manager);
    List<Manager> findAll();
    Manager findByEmail(String email);
    Manager findByNo(int no);
    int delete(int no);
    Manager findByEmailPassword(String email, String password);
}
