// @MatrixVariable 사용법
package ex03;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex03/test25")
public class Test25 {
    
    // 테스트:
    //      http://localhost:8888/app/ex03/test25/search/sonata/red/true/2013
    //
    @RequestMapping(value="search/{car}/{color}/{auto}/{year}",
            produces="text/plain;charset=UTF-8")
    public String m1(
            @PathVariable String car,
            @PathVariable String color,
            @PathVariable boolean auto,
            @PathVariable int year,
            Model model) throws Exception {
        
        return String.format("car=%s, color=%s, auto=%b, year=%d", 
                car, color, auto, year);
    }
    
    // @MatrixVariable 애노테이션을 사용하려면 스프링 설정에서 활성화시켜야 한다.
    // 1) XML 설정
    //
    //      <mvc:annotation-driven enable-matrix-variables="true"/>
    // 
    // 2) Java Config 설정
    //      
    //      @EnableWebMvc   <== 이 애노테이션을 추가한다.
    //      public class AppConfig {
    //          ...
    //      }
    // 
    // 테스트:
    //      .../search2/car=sonata;color=red;auto=true;year=2013
    //
    @RequestMapping(value="search2/{value}",
            produces="text/plain;charset=UTF-8")
    public String m2(
            @PathVariable String value,
            @MatrixVariable String car,
            @MatrixVariable String color,
            @MatrixVariable boolean auto,
            @MatrixVariable int year,
            Model model) throws Exception {
        
        return String.format("value: %s\ncar=%s, color=%s, auto=%b, year=%d", 
                value, car, color, auto, year);
    }
    
    // 테스트:
    //      .../search3/model/car=sonata;color=red/spec/auto=true;year=2013
    //
    @RequestMapping(value="search3/model/{value1}/spec/{value2}",
            produces="text/plain;charset=UTF-8")
    public String m3(
            // PathVariable 이 다르더라도 
            // 매트릭스 변수 이름로 값을 추출할 수 있다.
            @MatrixVariable String car,
            @MatrixVariable String color,
            @MatrixVariable boolean auto,
            @MatrixVariable int year,
            Model model) throws Exception {
        
        return String.format("car=%s, color=%s, auto=%b, year=%d", 
                car, color, auto, year);
    }
    
    // 테스트:
    //      .../search4/car/model=sonata;year=2013/tire/model=true;year=2016
    //
    @RequestMapping(value="search4/car/{value1}/tire/{value2}",
            produces="text/plain;charset=UTF-8")
    public String m4(
            // PathVariable 이 다르고, 매트릭스 변수 이름이 같을 때?
            // PathVariable과 매트릭스 변수명을 정확히 지정해야 한다.
            //
            @MatrixVariable(pathVar="value1", name="model") String cmodel,
            @MatrixVariable(pathVar="value1", name="year") int cyear,
            @MatrixVariable(pathVar="value2", name="model") String tmodel,
            @MatrixVariable(pathVar="value2", name="year") int tyear,
            Model model) throws Exception {
        
        return String.format("car=%s(%d), tire=%s(%d)\n", 
                cmodel, cyear, tmodel, tyear);
    }
    
    
}








