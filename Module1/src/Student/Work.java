
package Student;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    String name;
    int rollno;
    int age;

    Student(int rollno, int age, String name) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    void display() {
        System.out.println(name + " " + age + " " + rollno);
    }
}

public class Work {
    public static void main(String[] args) {
        ArrayList<Student> li = new ArrayList<>();

        li.add(new Student(1, 23, "vivek"));
        li.add(new Student(2, 25, "shubham"));
        li.add(new Student(3, 26, "rahul"));
        li.add(new Student(4, 22, "rohit"));
        li.add(new Student(5, 20, "saurav"));

        Collections.sort(li);

        for (int i = 0; i < li.size(); i++) {
            li.get(i).display();
        }
    }
}
