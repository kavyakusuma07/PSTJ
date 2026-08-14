import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String[]> readings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();
            readings.add(new String[]{sensorId, String.valueOf(temperature)});
        }
        readings.stream()
                .filter(r -> Double.parseDouble(r[1]) > 50)
                .collect(Collectors.groupingBy(
                        r -> r[0],
                        Collectors.averagingDouble(
                                r -> Double.parseDouble(r[1])
                        )
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e ->
                        System.out.println(e.getKey() + " " + e.getValue())
                );
        sc.close();
    }
}