package bitcamp.java110.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java110.cms.domain.Member;

//@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        
        String servletPath = httpRequest.getServletPath();
        
        if (servletPath.endsWith("add") ||
            servletPath.endsWith("delete")) {
            
            // 로그인 여부 검사
            HttpSession session = httpRequest.getSession();
            Member loginUser = (Member)session.getAttribute("loginUser");
            if (loginUser == null) {
                httpResponse.sendRedirect("/auth/login");
                return;
            }
        }
        
        chain.doFilter(request, response);
    }
}











