package bitcamp.java110.cms.context;

import java.io.File;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class ApplicationContext {
    HashMap<String,Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception {
        
        // 패키지 이름을 파일 경로로 바꾼다.
        String path = packageName.replace(".", "/");
        
        // 패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        File file = Resources.getResourceAsFile(path);
        System.out.println(file.getAbsolutePath());
        
        // 1) 인스턴스 생성
        // 해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에 
        // objPool에 보관한다.
    }
    
    public Object getBean(String name) {
        // objPool에서 주어진 이름의 객체를 찾아 리턴한다.
        return null;
    }
}
