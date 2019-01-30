// 사용자 정의 예외 사용하기
package ch21.e;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test04 {
  
  public static void main(String[] args) throws Exception{
   
    Scanner keyboard = null;
   try {
     keyboard = new Scanner(System.in);
     System.out.print("값1? ");
     int a = Integer.parseInt(keyboard.nextLine());
     int result = sum(a);
     System.out.println(result);
     
   } catch(Exception e){
     // 외부 파일에 출력하기
     StringWriter out = new StringWriter();
     PrintWriter out2 = new PrintWriter(out);
     // 상세 오류 정보를 String으로 받기
     e.printStackTrace(out2);
     
     out.close();
     out2.close();
     
     // StringWriter 객체에 저장된 문자열 꺼내기
     String str = out.toString();
     System.out.println(str);
   } finally {
     keyboard.close();
   }
   
  }
  
  static int sum(int value) { //f(n) + f(n-1)
    if (value == 1)
      return 1;
    return value + sum(value -1);
  }
  
}
