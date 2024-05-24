package com.study.serialization;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Person 객체를 생성합니다.
        Person person = new Person("지키", 27);

        // 직렬화된 Person 객체를 저장할 바이트 배열입니다.
        byte[] serializedPerson;

        // try-with-resources를 사용하여 ByteArrayOutputStream을 생성합니다.
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // try-with-resources를 사용하여 ObjectOutputStream을 생성합니다.
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {

                // Person 객체를 직렬화하여 ObjectOutputStream에 씁니다.
                oos.writeObject(person);
                // ByteArrayOutputStream으로부터 직렬화된 바이트 배열을 얻습니다.
                serializedPerson = baos.toByteArray();

            }
        }
        // 실제로 생성된 직렬화된 바이트 배열을 출력합니다.
        System.out.println(Arrays.toString(serializedPerson));
        // 직렬화된 바이트 배열을 Base64 문자열로 변환하여 출력합니다.
        System.out.println(Base64.getEncoder().encodeToString(serializedPerson));

        // ByteArrayInputStream을 생성하여 직렬화된 바이트 배열을 읽습니다.
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedPerson)) {
            // try-with-resources를 사용하여 ObjectInputStream을 생성합니다.
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {

                // ObjectInputStream으로부터 객체를 읽어들입니다.
                Object objectPerson = ois.readObject();
                // 읽어들인 객체를 Person 타입으로 캐스팅합니다.
                Person newPerson = (Person) objectPerson;
                // 역직렬화된 Person 객체를 출력합니다.
                System.out.println(newPerson);
            }

        }
    }
}

// Person 클래스는 Serializable 인터페이스를 구현합니다.
class Person implements Serializable {
    // 직렬화할 필드를 정의합니다.
    String name;
    int age;

    // Person 객체의 생성자입니다.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 객체의 문자열 표현을 반환하는 toString 메서드를 오버라이드합니다.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}