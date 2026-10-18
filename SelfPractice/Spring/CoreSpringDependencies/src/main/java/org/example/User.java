package org.example;

//@Component
// using component spring dont know what values to initialize in fileds --> can't create by isself
// cant acces jar file classes via @compontent becoz---> cant add @component in .class file

public class User {
    private String name;
    private  int age;


public User(int age ,String name ){
    this.name =name;
    this.age =age;

}

    public int getAge(){
        return age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
