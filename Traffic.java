import java.util.*;
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    int divide(int a, int b) {
        return a / b;
    }
}
public class Traffic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();
        Calculator calc = new Calculator();
        if (operator.equals("+")) {
            int actual = calc.add(a, b);
            int expected = 30;
            if (actual == expected)
                System.out.println("Test Passed");
            else
                System.out.println("Test Failed");
        } else if (operator.equals("/")) {

            int actual = calc.divide(a, b);
            int expected = a / b;

            if (actual == expected)
                System.out.println("Test Passed");
            else
                System.out.println("Test Failed");
        }
    }
}