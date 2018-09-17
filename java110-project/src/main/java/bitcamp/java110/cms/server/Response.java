package bitcamp.java110.cms.server;

import java.io.PrintWriter;

public class Response {
    PrintWriter out;
    
    public Response(PrintWriter out) {
        this.out = out;
    }
    
    public PrintWriter getWriter() {
        return this.out;
    }
    
}
