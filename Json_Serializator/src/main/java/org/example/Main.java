package org.example;

import Student.Student;
import json.serializator.Serializator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world, baby!");
        Student student = new Student();
        try {
            var str = Serializator.serialize(student);
            System.out.println(str);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}