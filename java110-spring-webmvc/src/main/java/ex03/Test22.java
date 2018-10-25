// @RestController - JSON 문자열 자동 출력
package ex03;

import java.sql.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex02.Car;
import ex02.Engine;
import ex02.Tire;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/ex03/test22")
public class Test22 {
    
    // 페이지 컨트롤러에 @RestController 를 붙이면 
    // 프론트 컨트롤러는 request handler의 리턴 값을 클라이언트로 바로 출력한다.
    // 1) 리턴 타입이 String과 primitive type 일 경우,
    //    => 문자열로 변환한 후 출력한다.
    // 2) 리턴 타입이 기타 객체일 경우,
    //    =? 리턴한 객체의 값을 JSON 형식의 문자열로 변환한 후 출력한다.
    // 
    // 실행 원리:
    // 1) HttpMessageConverter 규칙에 따라 만든 클래스를 찾는다. 
    //    => "Http Message"는 클라이언트로부터 받은 데이터, 
    //       클라이언트로 보내는 데이터를 가리킨다.
    // 2) 만약 HttpMessageConverter 구현체를 못 찾았다면?
    //    => 리턴 값을 바꿀 수 없기 때문에 실행 오류가 발생한다!
    //
    // HttpMessageConverter 구현체는 어떻게 추가하는가?
    // => 스프링 프레임워크는 기본 데이터 변환기로 다음 두 개의 클래스를 사용한다. 
    //          MappingJackson2HttpMessageConverter
    //          GsonHttpMessageConverter
    //
    // => MappingJackson2HttpMessageConverter는 다음 라이브러리에 들어있다.
    //
    //      "jackson-databind" 라이브러리.
    //
    // => GsonHttpMessageConverter 는 다음 라이브러리에 들어있다.
    //
    //      "google-gson" 라이브러리
    //
    // => 따라서 @RestController를 사용하려면 위의 두 개의 라이브러리 중 하나는 
    //    반드시 포함해야 한다.
    
    
    // 출력하는 데이터가 application/json이라고 프론트 컨트롤러에게 알려주면,
    // 프론트 컨트롤러는 리턴 객체를 Json 변환기를 이용하여 변환한 후 
    // 클라이언트로 출력한다.
    // 
    @RequestMapping(value="m1", produces="application/json;charset=UTF-8")
    public Car m1() throws Exception {
        
        Car car = new Car();
        car.setModel("소나타");
        car.setMaker("현대자동차");
        car.setAuto(true);
        car.setCreatedDate(Date.valueOf("2018-10-25"));
        
        car.setEngine(new Engine("비트엔진", 5000, 32));
        
        car.setMusics(new String[] {"오호라!","우헤헤","시간이 지난후"});
        
        car.setTires(new Tire[] {
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65)
        });
        
        return car;
    }
    
    // produces의 값을 text/plain으로 설정하면,
    // 프론트 컨트롤러는 리턴 값을 JSON으로 바꾸지 않고 
    // 그대로 출력한다.
    @RequestMapping(value="m2", produces="text/plain;charset=UTF-8")
    public String m2() throws Exception {
        return "ex03.Test22.m2()";
    }
    
    // produces 속성에 어떤 콘텐트를 리턴할 지 그 타입을 지정하지 않는다면,
    // 프론트 컨트롤러는 request handler의 리턴 타입에 따라 
    // 어떻게 처리할 지 결정한다.
    // String 이라면 그대로 출력하고,
    // 다른 타입이라면 JSON 데이터로 변경하여 출력한다.
    //
    @RequestMapping("m3")
    public Car m3() throws Exception {
        
        Car car = new Car();
        car.setModel("소나타");
        car.setMaker("현대자동차");
        car.setAuto(true);
        car.setCreatedDate(Date.valueOf("2018-10-25"));
        
        car.setEngine(new Engine("비트엔진", 5000, 32));
        
        car.setMusics(new String[] {"오호라!","우헤헤","시간이 지난후"});
        
        car.setTires(new Tire[] {
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65),
            new Tire("비트타이어", 65)
        });
        
        return car;
    }
    
    // @RestController 일 경우 리턴 타입이 String이라면 그대로 출력한다.
    @RequestMapping("m4")
    public String m4() throws Exception {
        return "ex03.Test22.m4()";
    }
    
    // @RestController 일 경우 리턴 타입이 primitive type이라면 
    // 문자열로 변환하여 그대로 출력한다.
    @RequestMapping("m5")
    public int m5() throws Exception {
        return 1000;
    }
    
    
    // 테스트:
    //      http://localhost:8888/ex02/Test22.html
    // 
    
    // 클라이언트가 보낸 JSON 데이터를 String 변수에 받기
    // => JSON 문자열 ---> String
    @RequestMapping("m6")
    public String m6(@RequestBody String jsonData) throws Exception {
        System.out.println(jsonData);
        return "ex03.Test22.m6()";
    }
    
    
    // => JSON 문자열 ---> Car 객체
    @RequestMapping("m7")
    public String m7(@RequestBody Car car) throws Exception {
        System.out.println(car);
        return "ex03.Test22.m7()";
    }
    
    // @RequestBody를 생략하면 안된다!
    // => 생략하면, 
    //    클라이언트가 보낸 데이터가 application/x-www-form-urlencoded 형식이라고 
    //    간주한다.
    //    즉 변수=값&변수=값&... 형태의 데이터로 간주하고 Car 객체에 값을 넣으려고 할 것이다.
    //    그러나 클라이언트는 JSON 형식으로 데이터를 보내기 때문에 
    //    Car 객체에는 제대로 값이 들어가지 않는다.
    // 
    @RequestMapping("m8")
    public String m8(Car car) throws Exception {
        System.out.println(car);
        return "ex03.Test22.m8()";
    }
    
    // 클라이언트가 보낸 JSON 데이터를 Map 객체에 담을 수도 있다.
    // 단, Map 변수를 그냥 선언하면 기존의 규칙대로 
    // 프론트 컨트롤러는 페이지 컨트롤러가 작업한 결과를 담는 용도로 사용하는 줄 알고
    // 빈 맵 객체를 넘겨줄 것이다.
    // Map 변수에 JSON 데이터를 받고 싶다면, 변수 앞에 @RequestBody를 명시해야 한다.
    // 이 경우 생략하면 안된다.
    // 
    @RequestMapping("m9")
    public String m9(@RequestBody Map data) throws Exception {
        System.out.println(data);
        return "ex03.Test22.m9()";
    }
    
}








