/* 클라이언트가 보낸 데이터 읽기 - 멀티파트 데이터 읽기 II
 * 
 */
package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

// Servlet API 3.0 부터 제공하는 멀티파트 처리기를 이용하기
// => 서블릿 선언부에 멀티파트 데이터를 처리함을 지정한다.
@MultipartConfig(maxFileSize=10_000_000)
@WebServlet("/ex04/servlet04")
public class Servlet04 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
            throws ServletException, IOException {
        
        // 테스트:
        // => http://localhost:8888/ex04/file2.html 페이지에서 값을 입력한 후 보내기 버튼 클릭
        
        
        // 멀티파트 데이터는 HttpServletRequest의 getParts(), getPart()
        // 메서드를 사용하여 꺼낸다.
        HttpServletRequest httpReq = (HttpServletRequest)req;
        
        String file1name = "";
        Part part = httpReq.getPart("file1");
        if (part.getSize() > 0) {
            file1name = UUID.randomUUID().toString();
            part.write(this.getServletContext()
                       .getRealPath("/upload/" + file1name));
        }
        
        String file2name = "";
        part = httpReq.getPart("file2");
        if (part.getSize() > 0) {
            file2name = UUID.randomUUID().toString();
            part.write(this.getServletContext()
                .getRealPath("/upload/" + file2name));
        }
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.printf("name=%s\n", req.getParameter("name"));
        out.printf("age=%d\n", 
                Integer.parseInt(req.getParameter("age")));
        out.printf("working=%b\n", 
                Boolean.parseBoolean(req.getParameter("working")));
        out.printf("file1=%s\n", file1name);
        out.printf("file2=%s\n", file2name);
        
    }
}

// 멀티파트 POST 요청
//
/*
POST /ex04/servlet03 HTTP/1.1
Host: localhost:8888
Content-Length: 3650
Cache-Control: max-age=0
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundarywdrfxUyAhH3oLyQ6
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Referer: http://localhost:8888/ex04/file.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
Connection: keep-alive

------WebKitFormBoundarywdrfxUyAhH3oLyQ6
Content-Disposition: form-data; name="name"

임꺽정
------WebKitFormBoundarywdrfxUyAhH3oLyQ6
Content-Disposition: form-data; name="age"

20
------WebKitFormBoundarywdrfxUyAhH3oLyQ6
Content-Disposition: form-data; name="working"

true
------WebKitFormBoundarywdrfxUyAhH3oLyQ6
Content-Disposition: form-data; name="file1"; filename="bit_logo.gif"
Content-Type: image/gif

GIF89a...
...
...
------WebKitFormBoundarywdrfxUyAhH3oLyQ6
Content-Disposition: form-data; name="file2"; filename=""
Content-Type: application/octet-stream


------WebKitFormBoundarywdrfxUyAhH3oLyQ6--

 */



























