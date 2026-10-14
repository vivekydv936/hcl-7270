
package records;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class demo {

    record Employee(int id, String name, String dept, BigDecimal salary) {}

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        
        employees.add(new Employee(101, "Vivek", "Data Science",new BigDecimal("45000.00")));

        employees.add(new Employee(102, "Rahul", "IT",new BigDecimal("55000.00")));

        employees.add(new Employee(103, "Aman", "HR", new BigDecimal("40000.00")));

        employees.add(new Employee(104, "Shubham", "Finance",new BigDecimal("60000.00")));
        employees.add(new Employee(105, "Aman", "it",new BigDecimal("89000.00")));
        employees.add(new Employee(106, "saurav", "HR",new BigDecimal("68000.00")));

       
        // for (Employee e : employees) {
        //     System.out.println(e);
        // }

        List<String> result = employees.stream().filter(e -> e.dept().equalsIgnoreCase("it"))
        .sorted((e1, e2) -> e2.salary().compareTo(e1.salary()))
        .map(Employee::name)
        .collect(Collectors.toList());

        System.out.println(result);

        // System.out.println(employees.get(0).name());
        //  System.out.println(employees.get(0).salary());
    }
}
