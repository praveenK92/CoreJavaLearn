package learn.java8.streamAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MkYong2 {

	public static void main(String[] args) {
		//p1();
		//p2();
		//p3();
		//p4();
		//p5();
		Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        
	}

	private static void p5() {
		Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
	}

	private static void p4() {
		Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");

        List<Integer> result = map.entrySet().stream()
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");

        List<String> result2 = map.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        result2.forEach(System.out::println);
	}

	private static void p3() {
		int[] intArray = {1, 2, 3, 4, 5, 6};
        Stream<int[]> streamArray = Stream.of(intArray);
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(x -> System.out.println(x));
	}

	private static void p2() {
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        stringStream.forEach(System.out::println);
	}

	private static void p1() {
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");
		HOSTING.put(5, "aws.amazon.com");
		HOSTING.put(6, "aws.amazon.com");

		String result = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result+= entry.getKey().toString();
			}
		}
		System.out.println("Before Java 8 : " + result);

		// Map -> Stream -> Filter -> String
		result = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(map -> map.getKey().toString())
				.collect(Collectors.joining());

		System.out.println("With Java 8 : " + result);
		
		Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        System.out.println(collect);
	}

}
