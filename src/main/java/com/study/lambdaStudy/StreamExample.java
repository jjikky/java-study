package com.study.lambdaStudy;

import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna");

        // 스트림을 사용하여 이름이 'A'로 시작하는 요소를 필터링하고, 대문자로 변환하고, 정렬하여 리스트로 수집
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))   // 이름이 'A'로 시작하는 요소 필터링
                .map(String::toUpperCase)               // 대문자로 변환
                .sorted()                               // 정렬
                .collect(Collectors.toList());          // 리스트로 수집

        System.out.println(filteredNames); // 출력: [ALICE, ANNA]

        // 숫자 리스트를 사용한 예제
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 스트림을 사용하여 짝수만 필터링하고, 제곱으로 변환하여 리스트로 수집
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)                // 짝수 필터링
                .map(n -> n * n)                        // 제곱으로 변환
                .collect(Collectors.toList());          // 리스트로 수집

        System.out.println(evenSquares); // 출력: [4, 16, 36, 64, 100]
    }
}