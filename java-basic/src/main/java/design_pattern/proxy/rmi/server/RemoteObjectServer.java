// RMI 기술 사용하기 - 원격 객체를 RMI 레지스트리 서버에 등록하기
package design_pattern.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {

  public static void main(String[] args) {
    // 실행 방법
    // => 먼저 RMI Registry 서버를 실행하라!
    // > rmiregistry
    // => 주의! RMI resgistry 서버가 클래스를 찾을 수 있도록 클래스를 찾을 수 있도록 .class 파일이 있는 디렉토리에서 실행하라.
    //  java-basic/bin/main> rmiregistry
    // 2) 그리고 이 클래스를 실행한다.
    
    // 원격 객체를 사용할 수 있도록 RMI Registry 서버에 등록하는 방법
    
    // 1) 보안 관리자 등록
    // => 원격에서 접속할 때 사용할 수 있는 자원의 범위를 통제하는 객체
//    if (System.getSecurityManager() == null)
//      System.setSecurityManager(new SecurityManager());

    try {

      // 2) 원격 객체(실제일하는 객체) 생성
      Calculator calcObj = new CalculatorImpl();

      // 3) 원격 객체와 통신을 담당할 프록시(클라이언트측 ORB)를 생성한다.
      // => 첫 번째 파라미터 : 원격 객체
      // => 두 번째 파라미터 : 포트 번호, 0으로 지정하면 임의의 유효한 포트 번호가 지정된다.
      // => 이렇게 RMI 기술을 사용하면 개발자가 skeleton(서버 측 ORB) 이나
      //  stub(클라이언트 측(ORB)를 작성할 필요가 없다.
      Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);

      // 4) Registry 서버에 스텁 객체를 등록해줄 도구를 준비한다.
      Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");

      // 5) Registry 도구를 사용하여 RMI Registry 서버에 stub를 등록한다.
      registry.rebind("calc", stub);
      
      System.out.println("Calculator 객체의 포록시(sutb) 가 RMI Regeistry 서버에 등록되었따.");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
