package HW;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    transient double GPA;
    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGPA() {
        return GPA;
    }
    public Student(String name, int age, double gPA) {
        this.name = name;
        this.age = age;
        GPA = gPA;
    }

    
    

    
}
