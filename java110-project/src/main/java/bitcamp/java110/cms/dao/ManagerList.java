package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Manager;

public class ManagerList {
    static Manager[] managers = new Manager[5];
    static int managerIndex = 0;
    
    public static void add(Manager student) {
        if (managerIndex == managers.length) {
            increaseStorage();
        }
        managers[managerIndex++] = student;
    }
    
    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length + 3];
        for (int i = 0; i < managers.length; i++) {
            newList[i] = managers[i];
        }
        managers = newList;
    }
    
    public static void remove(int no) {
        if (no < 0 || no >= managerIndex) {
            return;
        }
        
        for (int i = no; i < managerIndex - 1; i++) {
            managers[i] = managers[i + 1];
        }
        managerIndex--;
    }
    
    public static int size() {
        return managerIndex;
    }

    public static Manager get(int no) {
        if (no < 0 || no >= managerIndex) {
            return null;
        }
        
        return managers[no];
    }
    
}









