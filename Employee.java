import java.util.*;
public class Employee {
	public static void main(String[] args) {
		List<Integer> salaries = Arrays.asList(25000, 35000, 42000, 28000, 50000);
		salaries.stream()
			.map(x -> x + (x * 0.10) )
			.mapToInt(x -> x.intValue())
			.forEach(System.out::println);
	}

}
