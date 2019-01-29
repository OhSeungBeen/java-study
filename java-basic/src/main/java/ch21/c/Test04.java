// 애플리케이션 예외의 종류: Exception 계열의 예외 처리 III
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test04 {

  public static void main(String[] args) 
      // throws 문장도 catch 블록처럼 공통 수퍼 클래스 한 개로 보고할 수 있다.
      // => "이 메서드에서는 Exception 예외가 발생합니다"라는 의미다.
      // => throws 절에는 java.lang.Throwable 클래스만 선언할 수 있다.
      // Object 클래스와 같은 것은 선언할 수 없다.
      throws Exception { // 여러 예외를 퉁쳐서 하나로 표현할 수 있다.
  
//      throws ClassNotFoundException,  // 이 메서드에서 발생하는 예외의 목록을 지정한다.
//      NoSuchMethodException,          // 만약 메서드를 실행하는 중에 이런 예외가 발생한다
//      InstantiationException,         // 즉시 이 메서드의 실행을 멈추고
//      IllegalAccessException,         // 이 메서드를 호출한 쪽에 예외 정보를 보고한다.
//      InvocationTargetException {     // main()의 호출자? JVM이다.

    Scanner keyboard = new Scanner(System.in);

    // Exception 계열의 예외 방법
    // 1) try ~ catch로 예외 받기
    //    try {
    //             예외발생코드
    //    }catch(예외 파리미터 {
    //      예외처리코드
    //      }
    //
    // 2) 호출자에게 예외 처리를 떠넘기기
    // void 메서드() throws 예외클래스명, 예외클래스명, ...{
    //    예외가 발생할 수 있는 코드
    //  }

    // '방법2' 적용
    // => 메서드 선언부에 throws 절 추가하기
    // => 이 방식을 사용해야 하는 경우?
    //    이런 예외를 한 곳에서 처리하고 싶을 때 이 방식을 사용한다.
    // => "어이~~ 여기에 예외 처리하지 마! 호출자가 처리하도록 보고해. "라는 의미!

    Class<?> clazz  = Class.forName("ch21.c.PlusCommand");
    Constructor<?> constructor = clazz.getConstructor(Scanner.class);
    Command command = (Command) constructor.newInstance(keyboard);
    command.execute();

    System.out.println("종료");

  }
}
