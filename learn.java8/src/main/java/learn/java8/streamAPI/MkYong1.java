package learn.java8.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MkYong1 {

	public static void main(String[] args) {
		p1();
		// p2();
		// p3();
		// p4();
		// p5();
		// p6();
		// p7();
		// p8();

		int[] intArray = { 1, 2, 3, 4, 5 };

		IntStream intStream1 = Arrays.stream(intArray);
		intStream1.forEach(x -> System.out.println(x));

		// 2. Stream.of -> Stream<int[]>
		Stream<int[]> temp = Stream.of(intArray);

		// Cant print Stream<int[]> directly, convert / flat it to IntStream
		IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
		intStream2.forEach(x -> System.out.println(x));

	}

	private static void p8() {
		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("j", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		System.out.println("Original...");
		System.out.println(unsortMap);

		Map<String, Integer> result = new LinkedHashMap<>();

		// sort by key, a,b,c..., and put it into the "result" map
		unsortMap.entrySet().stream().sorted(Map.Entry.<String, Integer> comparingByValue())
				.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

		System.out.println("Sorted...");
		System.out.println(result);
	}

	private static void p7() {
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", new Date()));
		list.add(new Hosting(2, "linode.com", new Date()));
		list.add(new Hosting(3, "digitalocean.com", new Date()));

		// example 1
		Map<Integer, Hosting> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getThis));

		System.out.println("Result 1 : " + result1);

		// example 2
		Map<Integer, Hosting> result2 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));

		System.out.println("Result 2 : " + result2);
	}

	private static void p6() {
		Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
		List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

	private static void p5() {
		List<Developer> result1 = getDevelopers1();

		Map<String, Long> result2 = result1.stream()
				.collect(Collectors.groupingBy(Developer::getName, Collectors.counting()));
		Map<Integer, String> result3 = result1.stream().collect(Collectors.groupingBy(Developer::getAge,
				Collectors.mapping(Developer::getName, Collectors.joining(","))));

		System.out.println(result3);
	}

	private static void p4() {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		List<String> result = lines.stream().filter(lfg -> !"mkyong".equals(lfg)).collect(Collectors.toList());
		System.out.println(result);
		String result2 = lines.stream().filter(l -> {
			if ("mkyong".equals(l))
				return true;
			else
				return false;
		}).findAny().orElse(null);
		System.out.println(result2);
	}

	private static void p3() {
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		items.forEach(item -> System.out.print(item));
		System.out.println("\n2nd Way");

		items.forEach(item -> {
			if ("C".equals(item)) {
				System.out.println(item);
			}
		});
		System.out.println("3rd Way");

		items.forEach(System.out::print);
		System.out.println("\n4th Way");

		items.stream().filter(s -> s.contains("B")).forEach(System.out::println);
	}

	private static void p2() {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});
	}

	private static void p1() {
		List<Developer> listDevs = getDevelopers();
		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		System.out.println("After Sort");
		// lambda here!
		// listDevs.sort((Developer o1, Developer o2)->o1.age-o2.age);
		listDevs.sort((o1, o2) -> o1.name.compareTo(o2.name));

		// Comparator<Developer> salaryComparator = (o1,
		// o2)->o1.getSalary()-o2.getSalary();
		// listDevs.sort(salaryComparator.reversed());

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}

	private static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();
		result.add(new Developer("mkyong", 70_000, 33));
		result.add(new Developer("alvin", 80_000, 20));
		result.add(new Developer("jason", 100_000, 10));
		result.add(new Developer("iris", 170_000, 55));
		return result;
	}

	private static List<Developer> getDevelopers1() {
		List<Developer> result = new ArrayList<Developer>();
		result.add(new Developer("mkyong", 70_000, 33));
		result.add(new Developer("mkyong", 70_000, 33));
		result.add(new Developer("mkyong", 70_000, 33));
		return result;
	}

}

class Hosting{
	int id;
	String name;
	Date date;
	
	public Hosting(){}
	public Hosting(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public Hosting getThis(){
		return this;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
}

class Developer {
	int age;
	String name;
	int salary;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Developer(String name, int salary, int age) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Developer [age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}
}