package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao {
    
    static String defaultFilename = "data/manager2.dat";
    
    String filename;
    private List<Manager> list = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename = filename;
        
        File dataFile = new File(filename);
        try (
            FileInputStream in0 = new FileInputStream(dataFile);
            BufferedInputStream in1 = new BufferedInputStream(in0);
            ObjectInputStream in = new ObjectInputStream(in1);
        ){
            list = (List<Manager>)in.readObject();
//            while (true) {
//                try {
//                    Manager m = (Manager)in.readObject();
//                    list.add(m);
//                } catch (Exception e) {
//                    //e.printStackTrace();
//                    break;
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ManagerFile2Dao() {
        this(defaultFilename);
    }
    
    private void save() {
        File dataFile = new File(filename);
        try (
            FileOutputStream out0 = new FileOutputStream(dataFile);
            BufferedOutputStream out1 = new BufferedOutputStream(out0);
            ObjectOutputStream out = new ObjectOutputStream(out1);
        ){
            out.writeObject(list);
//            for (Manager m : list) {
//                out.writeObject(m);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Manager manager) {
        for (Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        save();
        return 1;
    }
    
    public List<Manager> findAll() {
        return list;
    }
    
    public Manager findByEmail(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        save();
        return 0;
    }
}
