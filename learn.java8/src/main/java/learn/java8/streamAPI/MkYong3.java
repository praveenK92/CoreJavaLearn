package learn.java8.streamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MkYong3 {

	public static void main(String[] args) {
		// p1();
		// p2();
		// p3();
		// p4();
		// p5();
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
		System.out.println("list : " + list);

	}

	private static void p5() {
		String[] s1 = new String[] { "a", "b", "c" };
		String[] s2 = new String[] { "d", "e", "f" };
		String[] s3 = new String[] { "g", "h", "i" };

		String[] result = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
		System.out.println(Arrays.toString(result));

		int[] int1 = new int[] { 1, 2, 3 };
		int[] int2 = new int[] { 4, 5, 6 };
		int[] int3 = new int[] { 7, 8, 9 };

		int[] result2 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();
		int[] result3 = IntStream
				.concat(Arrays.stream(int1), IntStream.concat(Arrays.stream(int2), Arrays.stream(int3))).toArray();

		System.out.println(Arrays.toString(result2));
		System.out.println(Arrays.toString(result3));
	}

	private static void p4() {
		String fileName = "./src/main/resources/lines.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			// br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.forEach(System.out::println);
	}

	private static void p3() {
		String fileName = "./src/main/resources/lines.txt";

		// read file into stream, try-with-resources
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			// 1. filter line 3
			// 2. convert all content to upper case
			// 3. convert it into a List
			list = stream.filter(line -> !line.startsWith("Hibernate")).map(String::toUpperCase)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}

	private static void p1() {
		StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
		sj.add("2016");
		sj.add("02");
		sj.add("26");
		String result = sj.toString(); // prefix-2016/02/26-suffix
		System.out.println(result);
		String result1 = String.join("-", "2015", "10", "31");
		System.out.println(result1);

		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		String result3 = list.stream().map(x -> x).collect(Collectors.joining(" || "));
		System.out.println(result3);
	}

	static void p2() {

		List<Game> list = Arrays.asList(new Game("Dragon Blaze", 5), new Game("Angry Bird", 5),
				new Game("Candy Crush", 5));

		// {Dragon Blaze, Angry Bird, Candy Crush}
		String result = list.stream().map(x -> x.getName()).collect(Collectors.joining(", ", "{", "}"));
		System.out.println(result);

	}

}

class Game {
	String name;
	int ranking;

	public Game(String name, int ranking) {
		this.name = name;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
}