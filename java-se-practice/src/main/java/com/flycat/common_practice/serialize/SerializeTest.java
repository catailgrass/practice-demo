package com.flycat.common_practice.serialize;

import java.io.*;

public class SerializeTest {

    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        testObject.setName("sddd");
        testObject.setPwd("sssssss");

        try {
            //
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(testObject);
            objectOutputStream.close();

            byte[] result = byteArrayOutputStream.toByteArray();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            TestObject testObject1 = (TestObject) objectInputStream.readObject();
            System.out.println(testObject.toString());
            System.out.println(testObject1.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
