package bitcamp.java110.cms.service.impl;

import java.util.List;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    MemberDao memberDao;
    ManagerDao managerDao;
    PhotoDao photoDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public void add(Manager manager) {
        // 매니저 등록관 관련된 업무는 Service 객체에서 처리한다.
        try {
            memberDao.insert(manager);
            managerDao.insert(manager);
            
            if (manager.getPhoto() != null) {
                photoDao.insert(manager.getNo(), manager.getPhoto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Manager> list() {
        return managerDao.findAll();
    }
}










