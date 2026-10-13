package Assignments.Assignment1;
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    void display() {
        System.out.println(
            "ID: " + id +
            ", Name: " + name +
            ", Salary: " + salary
        );
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // CREATE
        employees.add(new Employee(3, "Rahul", 30000));
        employees.add(new Employee(1, "Vivek", 45000));
        employees.add(new Employee(4, "shreyansh", 50000));
        employees.add(new Employee(5, "Aman", 25000));
        employees.add(new Employee(2, "Rohit", 40000));

        // READ
       
        for (Employee e : employees) {
            e.display();
        }

        // SEARCH
       
        // for (Employee e : employees) {
        //     if (e.id == 3) {
        //         e.display();
        //         break;
        //     }
        // }

        // // UPDATE
        System.out.println("Update Employee ID 3:");
        for (Employee e : employees) {
            if (e.id == 3) {
                e.name = "Shubham";
                e.salary = 35000;
                break;
            }
        }

        // // DELETE USING ITERATOR
       
        // Iterator<Employee> it = employees.iterator();

        // while (it.hasNext()) {
        //     Employee e = it.next();

        //     if (e.id == 5) {
        //         it.remove();
        //         break;
        //     }
        // }


        // for (Employee e : employees) {
        //     e.display();
        // }

        // // ITERATOR: FORWARD
       
        // Iterator<Employee> itr = employees.iterator();

        // while (itr.hasNext()) {
        //     itr.next().display();
        // }

        // // LISTITERATOR: FORWARD
       
        // ListIterator<Employee> li = employees.listIterator();

        // while (li.hasNext()) {
        //     li.next().display();
        // }

        // // LISTITERATOR: BACKWArd
        // System.out.println("\nListIterator Backward:");
        // ListIterator<Employee> reverse =
        //     employees.listIterator(employees.size());

        // while (reverse.hasPrevious()) {
        //     reverse.previous().display();
        // }

        // // INCREASING ORDER OF ID
        // ArrayList<Employee> ascending =
        //     new ArrayList<>(employees);

        // Collections.sort(ascending);

        // System.out.println("\nIncreasing Order of ID:");
        // for (Employee e : ascending) {
        //     e.display();
        // }

        // // DECREASING ORDER OF ID
        // ArrayList<Employee> descending =
        //     new ArrayList<>(employees);

        // Collections.sort(descending, Collections.reverseOrder());

        // System.out.println("\nDecreasing Order of ID:");
        // for (Employee e : descending) {
        //     e.display();
        // }
    }
}
