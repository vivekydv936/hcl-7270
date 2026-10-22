package com.example.HRMS.Controller;

import com.example.HRMS.Model.DemoEmployee;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private DemoEmployee demoEmployee;


    @GetMapping("/")
    public String welcome(){

        return " welcome to hrms App";
    }

    @GetMapping("/add")
    public int sum(){
        System.out.println("inside/add controller point");
       int result= demoEmployee.add();

        return result;
    }

    @GetMapping("/sqrt")
    public double getSquare(){
        System.out.println("enterred in getSquare fun");
       return demoEmployee.squareRoot();
    }

}
