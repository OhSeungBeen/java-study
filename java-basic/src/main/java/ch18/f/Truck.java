package ch18.f;

// 자동차가 가져야할 기본 필드와 메서드를 상속 받는다.
public class Truck extends AbstractCar {
  
  // 그리고 서브 클래스에게 구현하라고 맡겨진 추상 메서드를 정의한다.
  @Override
  public void run() {
    System.out.println("덜컹 덜컹 달린다!");
  }
  
}
