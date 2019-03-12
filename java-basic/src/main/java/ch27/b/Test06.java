// reflection API - 클래스가 갖고 있는 메서드 정보 알아내기
// => 클래스 안을 들여다 볼 때 사용하는 도구이다.
package ch27.b;

import java.lang.reflect.Method;

public class Test06 {
  public static void main(String[] args) throws Exception {

    Class<?> clazz = C.class;

    Method[] methods = clazz.getMethods();
    for(Method m : methods) {
      System.out.printf("클래스명: %s\n", 
          m.getDeclaringClass().getSimpleName());
      
      System.out.printf("====> %s\n",m.getName());

      }
  }
}
