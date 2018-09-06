package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherList {
    static Teacher[] teachers = new Teacher[5];
    static int teacherIndex = 0;
    
    public static void add(Teacher student) {
        if (teacherIndex == teachers.length) {
            increaseStorage();
        }
        teachers[teacherIndex++] = student;
    }
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length + 3];
        for (int i = 0; i < teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }
    
    public static void remove(int no) {
        if (no < 0 || no >= teacherIndex) {
            return;
        }
        
        for (int i = no; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i + 1];
        }
        teacherIndex--;
    }
    
    public static int size() {
        return teacherIndex;
    }

    public static Teacher get(int no) {
        if (no < 0 || no >= teacherIndex) {
            return null;
        }
        
        return teachers[no];
    }
    
}









