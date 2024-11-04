package HW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sem3.Task1.UserData;

/*
 * Разработайте класс Studet с полями String name, int age, transient double GPA
 * Обеспечить поддержку сериализации
 * Создать объекта класса Student и инициализировать его
 * Сериализовать его в файл
 * Ввывести все поля и сериализовать их
 */

public class Program {
    public static void main(String[] args) throws Exception {
        Student student = new Student("Sasha", 30, 4.0);

        try (FileOutputStream fileOutputStream = new FileOutputStream("studentDataFile.bin")){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(student);
                System.out.println("Студент сериализован");
            }
        }

        try (FileInputStream fileInputStream = new FileInputStream("studentDataFile.bin")){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                student= (Student)objectInputStream.readObject();
                System.out.println("Объект десериализован");
            }
        }

        System.out.println("Объект UserData десериализован.");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Пароль (должен быть null, так как transient): " + student.getGPA());


    }
}
