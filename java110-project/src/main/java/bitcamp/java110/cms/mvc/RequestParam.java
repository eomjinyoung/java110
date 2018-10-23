package bitcamp.java110.cms.mvc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    String value(); // 파라미터 이름
    String defaultValue() default ""; // 파라미터 값
}
