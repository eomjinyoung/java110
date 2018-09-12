package bitcamp.java110.cms.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

//@Component
public class ManagerFileDao implements ManagerDao {
    private List<Manager> list = new ArrayList<>();
    
    public ManagerFileDao() {
        File dataFile = new File("data/manager.dat");
        try (
            BufferedReader in = 
                new BufferedReader(new FileReader(dataFile))
        ){
            while (true) {
                String line = in.readLine();
                if (line == null)
                    break;
                String[] values = line.split(",");
                
                Manager m = new Manager();
                m.setEmail(values[0]);
                m.setName(values[1]);
                m.setPassword(values[2]);
                m.setPosition(values[3]);
                m.setTel(values[4]);
                
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File dataFile = new File("data/manager.dat");
        try (
            BufferedWriter out = 
                new BufferedWriter(new FileWriter(dataFile))
        ){
            for (Manager m : list) {
                out.write(
                    String.format("%s,%s,%s,%s,%s\n", 
                        m.getEmail(),
                        m.getName(),
                        m.getPassword(),
                        m.getPosition(),
                        m.getTel()));
            }
            out.flush();
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
