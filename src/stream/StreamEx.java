package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

  public static void main(String[] args) {

    /**
     * Stream
     * 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
     *
     * 특징
     * iterator 처럼 1회용임
     * 최종 연산 전까지 연산 지연 -> 나중에 수행
     * 작업을 내부 반복으로 처리
     * 병렬로 처리
     *
     * 스트림 생성은 3 가지 과정을 가짐
     * 1. 스트림 생성
     * 2. 중간 연산 (0 ~ n번)
     * 3. 최종 연산 (0 ~ 1번)
     **/

    // Sample
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    list.stream()
        .distinct()
        .limit(5)
        .sorted()
        .forEach(i -> System.out.println(i));

    // 스트림 생성
    int[] intArr = {1,2,3,4,5};
    IntStream intStream = Arrays.stream(intArr);
    // 스트림은 닫히면 새로 생성해야 함
//    System.out.println("average = " + intStream.average());
    System.out.println("count = " + intStream.count());

    // 임의의 난수를 갖는 스트림
    // limit을 하지 않으면 무한으로 생성
    IntStream randomStream = new Random().ints();
    randomStream.limit(5).forEach(System.out::println);
    
    IntStream randomStream1 = new Random().ints(5,10);
    randomStream1.limit(5).forEach(System.out::println);

    // 지정된 범위를 갖는 난수를 갖는 스트림
    // iterate()는 이전 요소를 seed로 해서 다음 요소를 계산
    // generate()는 seed를 사용하지 않음
    Stream<Integer> iterateStream = Stream.iterate(1, n->n+3);
    iterateStream.limit(5).forEach(System.out::println);

    Stream<Integer> generateStream = Stream.generate(()->1);
    generateStream.limit(5).forEach(System.out::println);
  }
}