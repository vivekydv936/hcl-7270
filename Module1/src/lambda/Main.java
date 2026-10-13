package lambda;
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;

        Calculator subtract = (a, b) -> a - b;

        Calculator multiply = (a, b) -> a * b;

        Calculator divide = (a, b) -> a / b;

        Calculator modulus = (a, b) -> a % b;

        int x = 20;
        int y = 5;

        System.out.println("Addition: " + add.calculate(x, y));
        System.out.println("Subtraction: " + subtract.calculate(x, y));
        System.out.println("Multiplication: " + multiply.calculate(x, y));
        System.out.println("Division: " + divide.calculate(x, y));
        System.out.println("Modulus: " + modulus.calculate(x, y));

        
    }
}
