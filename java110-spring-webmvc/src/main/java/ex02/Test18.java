// HTTP 요청 헤더 알아내기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test18")
public class Test18 {
    
    @RequestMapping(value="m1", produces="text/plain")
    @ResponseBody
    public String m1(
            @RequestHeader("User-Agent") 
            String userAgent,
            
            @RequestHeader(value="Content-Type", required=false) 
            String contentType,
            
            @RequestHeader("Accept")
            String accept) {
        
        return String.format("%s\n %s\n %s\n", 
                userAgent, contentType, accept);
    }
    
}









