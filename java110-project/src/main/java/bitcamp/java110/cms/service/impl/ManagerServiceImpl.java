package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired MemberDao memberDao;
    @Autowired PhotoDao photoDao;
    @Autowired ManagerDao managerDao;
    
    @Transactional(
            // 트랜잭션 관리자의 이름이 transactionManager 라면 
            // 다음 속성은 생략해도 된다.
            //transactionManager="transactionManager",
            
            // 이 메서드를 호출하는 쪽에 이미 트랜잭션이 있으면 그 트랜잭션에 소속되게 하고,
            // 없으면 새 트랜잭션을 만들서 수행한다.
            // 기본 값은 Propagation.REQUIRED 이다. 
            propagation=Propagation.REQUIRED,
            
            // 메서드를 실행 중에 Exception 예외가 발생하면 rollback을 수행한다.
            // 기본 값은 Exception.class 이다.
            rollbackFor=Exception.class)
    @Override
    public void add(Manager manager) {
        memberDao.insert(manager);
        managerDao.insert(manager);
        
        if (manager.getPhoto() != null) {
            
            HashMap<String,Object> params = new HashMap<>();
            params.put("no", manager.getNo());
            params.put("photo", manager.getPhoto());
            
            photoDao.insert(params);
        }
    }
    
    @Override
    public List<Manager> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        return managerDao.findAll(params);
    }
    
    @Override
    public Manager get(int no) {
        return managerDao.findByNo(no);
    }
    
    @Transactional
    @Override
    public void delete(int no) {
        if (managerDao.delete(no) == 0) {
            throw new RuntimeException("해당 번호의 데이터가 없습니다.");
        }
        photoDao.delete(no);
        memberDao.delete(no);
    }
}










