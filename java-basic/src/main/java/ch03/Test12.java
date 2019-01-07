// 배열 - 선언과 초기화시키는 문법
package ch03;

public class Test12 {

  public static void main(String[] args){
    int[] arr1;
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    
    // 2) 레퍼런스 변수를 선언할 때 배열 생성하기
    int[] arr2 = new int[5];
    
    // 3) 레퍼런스 변수를 선언할 때 배열 생성과 값을 초기화시키기
    // => 초기 값을 설정할 때는 배열의 개소룰 지정하면 안된다.
    int[] arr3 =  new int[] {100, 100, 90, 90, 60};
    
    // 4) 배열 생성과 동시에 값을 초기화시킬 때 배열 생성 문법을 생략할 수 있다.
    int[] arr4 = {100, 90, 80, 70, 60};
    
    // 5) 레퍼런스를 별도로 선언한 경우에는 4번 방식으로 초기화시킬 수 없다.
    int[] arr5;
    //arr5 = {90,90,90,90}; // 컴파일 오류!
    arr5 = new int[] {100, 90, 80, 80};
  }
}
