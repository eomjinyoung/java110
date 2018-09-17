package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        try (
            // 서버에 연결하기
            Socket socket = new Socket("192.168.0.10", 8888);
            
            // 서버에 데이터를 보내고 읽을 도구를 준비하기
            PrintStream out = new PrintStream(
                                new BufferedOutputStream(
                                        socket.getOutputStream()));
            BufferedReader in = new BufferedReader(
                               new InputStreamReader(
                                  socket.getInputStream()));
        ) {
            out.println("HELLO"); out.flush();
            System.out.println(in.readLine());
            
            while (true) {
                String requestLine = prompt();
                out.println(requestLine); out.flush();
                while (true) {
                    String responseLine = in.readLine();
                    System.out.println(responseLine);
                    if (responseLine.length() == 0)
                        break;
                }
                if (requestLine.equals("EXIT")){
                    break;
                } 
            }
            
        }
        
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("입력> ");
        return keyIn.nextLine();
    }
}






















