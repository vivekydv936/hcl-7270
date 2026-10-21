package org.example.SetterDi;

import org.example.SetterDi.AppConfig;
import org.example.SetterDi.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp =context.getBean(Employee.class);
        emp.displayAddress();
    }
}
