package learn.java8.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestCheck {

	public static void main(String[] args) {
		// p1();
		List<Integer> ss = Arrays.asList(
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		List<Integer> result = new ArrayList<Integer>();

		Stream<Integer> stream = ss.parallelStream();
		stream.map(s -> {
			synchronized (result) {
				if (result.size() < 10) {
					result.add(s);
				}
			}
			return s;
		}).forEach(e -> {
		});
		System.out.println(result);
	}

	private static void p1() {
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());

		flatStream.forEach(System.out::println);
	}
}
