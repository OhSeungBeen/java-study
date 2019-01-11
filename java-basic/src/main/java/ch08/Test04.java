// 그 밖의 클래스 멤버들
package ch08;

class My4{
  // 클래스 필드 = 스태틱 필드(변수)
  // => 클래스가 로딩될 때 생성되는 변수
  // => 클래스 필드도 인스턴스 필드처럼 기본 값으로 자동 초기화 된다.
  //    정수(byte, short, int, long, char) => 0
  //    부동소수점(float, double) = 0.0
  //    논리(boolean) => false
  //    레퍼런스 => null
  // => 참고! 로컬변수는 절대로 자동 초기화 되지 않는다.
  static int a;
  
  // 클래스 블록 = 스태틱 블록
  // => 클래스가 로딩 될 때 클래스 변수를 생성한 후 실행되는 블록
  // => 따라서 딱 한번 실행된다.
  static {
    System.out.println("오호라!");
  }
  
  static {
    System.out.println("이것이 스태틱 블록이네! 여러 개를 선언할 수 있네!");
  }
  
  //클래스 메서드 = 스태틱 메서드
  // => 클래스 이름으로 호출하는 함수
  static void m1() {
    System.out.println("나를 호출하셨군요!");
  }
  
}

public class Test04 {
  public static void main(String[] args) {
    System.out.println("********************");
    
    // 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.
    // 따라서 스태틱 블록이 실행되지 않는다.
    My4 obj1;
    
    System.out.println("--------------------");
    // 클래스가 로딩되는 때? 클래스 멤버(필드, 메서드)를 사용할때!
    // - 클래스 필드를 사용할 때
   // My4.a = 300;
    
    // - 클래스 메서드를 사용할 때
    My4.m1();
    My4.m1(); // 한번 클래스가 로딩되면 다시 로딩되지 않는다. 따라서 스태틱 블록은 딱 한번 실행된다.
  }
}

