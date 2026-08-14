import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class BankAccount {
    double balance;
    void deposit(double x) { balance += x; }
    void withdraw(double x) { if (x <= balance) balance -= x; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        BankAccount a = new BankAccount();
        List<String> list = IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine())
                .collect(Collectors.toList());
        list.stream()
            .map(s -> s.split(" "))
            .forEach(x -> {
                double amount = Double.parseDouble(x[1]);
                if (x[0].equalsIgnoreCase(("deposit")))
                    a.deposit(amount);
                else
                    a.withdraw(amount);
            });
        System.out.println("Final balance: " + a.balance);
    }
}