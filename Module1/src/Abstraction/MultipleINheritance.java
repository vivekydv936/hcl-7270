package Abstraction;

interface Father {
    void gardening();
}

interface Mother {
    void cooking();
}

class Child implements Father, Mother {

    @Override
    public void gardening() {
        System.out.println("Father's skill: Gardening");
    }

    @Override
    public void cooking() {
        System.out.println("Mother's skill: Cooking");
    }

    public void playing() {
        System.out.println("Child is playing");
    }
}

public class MultipleINheritance {

    public static void main(String[] args) {

        Child obj = new Child();

        obj.gardening();
        obj.cooking();
        obj.playing();
    }
}