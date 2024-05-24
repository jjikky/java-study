package com.study.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


class DeserializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        byte[] serializedPerson =
                {-84, -19, 0, 5, 115, 114, 0, 30, 99, 111, 109, 46, 115, 116, 117, 100, 121, 46, 115, 101, 114, 105, 97, 108, 105, 122, 97, 116, 105, 111, 110, 46, 80, 101, 114, 115, 111, 110, -78, 0, 13, -48, 36, 85, -101, 5, 2, 0, 2, 73, 0, 3, 97, 103, 101, 76, 0, 4, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 0, 0, 0, 27, 116, 0, 6, -20, -89, -128, -19, -126, -92};

        //직렬화된 바이트 배열을 입력 스트림으로 읽습니다.
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedPerson)) {
            // ByteArrayInputStream에서 객체를 읽어들입니다.
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {

                // ObjectInputStream으로부터 객체를 읽어들입니다.
                Object objectMember = ois.readObject();

                // 읽어들인 객체를 Person 타입으로 캐스팅
                Person newPerson = (Person) objectMember;

                // 역직렬화된 Person 객체를 출력
                System.out.println(newPerson);
            }
        }
    }
}