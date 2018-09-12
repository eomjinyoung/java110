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
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFile2Dao implements TeacherDao {
    
    static String defaultFilename = "data/teacher2.dat";
    
    String filename;
    private List<Teacher> list = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public TeacherFile2Dao(String filename) {
        this.filename = filename;
        
        File dataFile = new File(filename);
        try (
            FileInputStream in0 = new FileInputStream(dataFile);
            BufferedInputStream in1 = new BufferedInputStream(in0);
            ObjectInputStream in = new ObjectInputStream(in1);
        ){
            list = (List<Teacher>)in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public TeacherFile2Dao() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int insert(Teacher teacher) {
        for (Teacher item : list) {
            if (item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1;
    }
    
    public List<Teacher> findAll() {
        return list;
    }
    
    public Teacher findByEmail(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        save();
        return 0;
    }
}
