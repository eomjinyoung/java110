package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    int insert(Manager manager) 
            throws MandatoryValueDaoException, DuplicationDaoException;
    List<Manager> findAll();
    Manager findByEmail(String email);
    default Manager findByNo(int no) {return null;}
    default int delete(String email) {return 0;}
    default int deleteByNo(int no) {return 0;}
}
