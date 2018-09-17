package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {
    
    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;
    
    public ServerApp() throws Exception {
        createIoCContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();
    }
    
    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/application-context.xml");
    }
    
    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }
    }
    
    private void logBeansOfContainer() {
        System.out.println("------------------------");
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for (String name : nameList) {
            System.out.println(name);
        }
        System.out.println("------------------------");
    }
    
    public void service() throws Exception {
        // 클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 중...");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트가 연결되었음!");
            
            RequestWorker worker = new RequestWorker(socket);
            new Thread(worker).start();
        }
    }
    
    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }
    
    class RequestWorker implements Runnable {
        Socket socket;
        
        public RequestWorker(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            // 이 메서드에 "main" 스레드에서 분리하여 독립적으로 수행할 코드를 둔다.
            try (
                Socket socket = this.socket;
                PrintWriter out = new PrintWriter(
                        new BufferedOutputStream(
                                socket.getOutputStream()));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
            ) {
                String requestLine = in.readLine();
                System.out.println("클라이언트 요청 받았음!");
                
                // 요청 객체 준비
                Request request = new Request(requestLine);
                
                // 응답 객체 준비
                Response response = new Response(out);

                RequestMappingHandler mapping = 
                        requestHandlerMap.getMapping(request.getAppPath());
                if (mapping == null) {
                    out.println("해당 요청을 처리할 수 없습니다.");
                    out.println();
                    out.flush();
                    return;
                }
                
                try {
                    // 요청 핸들러 호출
                    mapping.getMethod().invoke(mapping.getInstance(), request, response);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("요청 처리 중에 오류가 발생했습니다.");
                }
                out.println();
                out.flush();
                
            } catch (Exception e) {// try
                System.out.println(e.getMessage());
            } finally {
                System.out.println("클라이언트에게 응답했음!");
                System.out.println("클라이언트와 연결을 끊음!");
            }
            
            
        } // run() 
        
    } // RequestWorker class
    
} // ServletApp class






















