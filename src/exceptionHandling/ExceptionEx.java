package exceptionHandling;

public class ExceptionEx {

  public static void main(String[] args) {
    예외처리1();
    예외처리2();
    예외처리3();
  }

  private static void 예외처리1() {
    /**
     * try-catch-finally
     * 한 줄이어도 괄호{} 생략 불가
     */

    try {
      // 1. ArithmeticException 산술 에러가 발생하므로 ArithmeticException 인스턴스가 생성
      System.out.println(0 / 0);

      // 2. 위 에러에서 발생한 인스턴스와 catch 블럭 내의 참조변수를 instanceOf를 통해 검사
    } catch (ArithmeticException ae) {
      System.out.println("0으로 나눌 수 없습니다");

      // 3. 모든 예외의 부모 클래스인 Exception 이므로 여과되지 못한 예외 처리 (여기선 실행 x)
    } catch (Exception e) {
      System.out.println("모든 에러는 여기서 처리");

      // 4. finally 는 위 결과에 상관없이 무조건 실행되는 부분
      // 에러가 발생해도 처리해야하는 db 연결 종료 등을 처리
    } finally {
      System.out.println("finally 수행");
    }
    System.out.println("종료 \n");
  }

  private static void 예외처리2() {
    /** 고의로 예외 발생시키기
     * 예외 클래스의 객체를 만든 후 throw 키워드를 통해 발생
     */

    try {
      Exception e = new Exception("고의 발생");
      throw e;
    } catch (Exception e) {
      System.out.println("고의적인 에러 발생");

      // 메서드 정보와 예외 메시지를 출력
      e.printStackTrace();

      // 발생한 예외 클래스의 인스턴스의 메시지를 출력
      System.out.println("예외 메시지 : " + e.getMessage());
    }
    System.out.println("종료 \n");
  }

  private static void 예외처리3() {
    /** 메서드에 예외 선언하기
     * try-catch 문 을 이용하지 않고 예외를 메서드에 선언하는 방법
     * 메서드 선언부에 throws 를 사용해 메서드 내에서 발생할 수 있는 예외를 적음
     * 쉼표, 로 여러 예외 처리 가능
     *
     * (중요) 메서드를 사용하는 쪽에서 예외에 대한 처리를 강요받기 때문에 견고한 프로그래밍이 가능
     *
     * 3_2에서 예외를 발생
     * -> throws 를 통해 3_2를 사용하는 3_1에서 처리를 강요
     * -> 하지만 3_1도 예외처리를 throws 로 넘겨줌
     * -> 예외처리3()이 try-catch 를 통해 예외를 처리
     */

    try {
      예외처리3_1();
    } catch (Exception e) {
      System.out.println("예외처리3_2의 예외를 처리");
    }
  }

  // throws 를 통해 해당 메서드를 사용하는 쪽으로 예외 처리를 넘겨줌
  private static void 예외처리3_1() throws Exception {
    예외처리3_2();
  }

  // throws 를 통해 해당 메서드를 사용하는 쪽으로 예외 처리를 넘겨줌
  private static void 예외처리3_2() throws Exception {
    // 예외 발생시킴
    throw new Exception();
  }
}