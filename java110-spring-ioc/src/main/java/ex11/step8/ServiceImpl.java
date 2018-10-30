package ex11.step8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {
     
    @Autowired Dao1 dao1;
    @Autowired Dao2 dao2;
    @Autowired Dao3 dao3;
    
    @Override
    public void add() {
        dao1.insert();
        dao2.insert();
        dao3.insert();
    }

    @Override
    public void update() {
        System.out.println("update()");
        
    }

    @Override
    public void delete() {
        System.out.println("delete()");
        
    }

    @Override
    public void list() {
        System.out.println("list()");
        
    }

    @Override
    public int addPhoto(String filename) {
        System.out.println("addPhoto(): " + filename);
        
        if (filename == null) {
            throw new RuntimeException("파일이 없습니다!");
        }
        
        return 1;
    }
    
    
}











