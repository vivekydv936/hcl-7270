package Try_Catch;
public class Demo {
    public static void main(String[] args) {

        // 1. TRY-CATCH with an Exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e);
        }

        // 2. Catching Exception
        try {
            String name = null;
            System.out.println(name.length());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }

        // 3. Catching Throwable
        try {
            int result = 10 / 0;
        } catch (Throwable t) {
            System.out.println("Caught Throwable: " + t);
        }

        // 4. Explicitly throwing an exception
        try {
            throw new Exception("Something went wrong");
        } catch (Exception e) {
            System.out.println("Manually thrown: " + e.getMessage());
        }

        // 5. Demonstrating Error
        try {
            throw new Error("Serious problem");
        } catch (Error e) {
            System.out.println("Caught Error: " + e.getMessage());
        }

        System.out.println("Program completed");
    }
}
