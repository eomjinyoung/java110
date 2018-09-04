import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        // 1) 키보드 입력을 처리할 객체 준비
        Scanner keyIn = new Scanner(System.in);
        
        // 2) 사용자로부터 회원 정보 입력 받기
        
        while (true) {
            System.out.print("이름? ");
            String name = keyIn.nextLine();
            
            System.out.print("이메일? ");
            String email = keyIn.nextLine();
            
            System.out.print("암호? ");
            String password = keyIn.nextLine();
            System.out.printf("%s, %s, %s\n", name, email, password);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
        
        
    }
}








