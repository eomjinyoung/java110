// request handler의 파라미터 III
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02/test14")
public class Test14 {
    
    // 클라이언트가 보낸 값을 객체로 받기

    // primitive type이나 String이 아닌 도메인 객체를 선언하게 되면
    // 프론트 컨트롤러는 해당 도메인 객체의 인스턴스를 만든 후에
    // 클라이언트가 보낸 데이터 중에서 프로퍼티 이름과 일치하는 것을 찾아 
    // 자동으로 주입해준다.
    @RequestMapping("m1")
    public String m1(
            Car car,
            Model model) {
        
        model.addAttribute("car", car);
        return "/ex02/Test14.jsp";
    }
    
    
    // 도메인 객체와 낱개 데이터 모두 받기
    // => 클라이언트 보낸 데이터가 도메인 객체의 프로퍼티명과도 일치하고,
    //    낱개로 받는 변수명과도 일치한다면,
    //    프론트 컨트롤러는 둘 다 넣어준다.
    @RequestMapping("m2")
    public String m2(
            Car car,
            String maker, 
            Model model) {
        
        System.out.println(maker);
        model.addAttribute("car", car);
        return "/ex02/Test14.jsp";
    }
    
}









