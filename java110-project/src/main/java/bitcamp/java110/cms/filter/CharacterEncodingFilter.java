package bitcamp.java110.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
    
    String encoding = "ISO-8859-1";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("encoding") != null) {
            this.encoding = filterConfig.getInitParameter("encoding");
        }
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        // 서블릿을 실행하기 전에 클라이언트가 보낸 값에 대해 문자표를 지정한다.
        request.setCharacterEncoding(this.encoding);
        
        // 다음 필터가 있다면 그 필터를 실행하고, 없다면 최종 목적지인 서블릿을 실행한다.
        chain.doFilter(request, response);
        
    }
}










