import java.util.*;
import java.util.stream.*;
public class Kadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = IntStream.range(0, n)
                .map(i -> sc.nextInt())
                .toArray();

        int maxSum = IntStream.range(0, n)
                .map(i -> IntStream.range(0, i + 1)
                        .map(j -> arr[j])
                        .sum())
                .max()
                .orElse(0);

        System.out.println(maxSum);

        sc.close();
    }
}