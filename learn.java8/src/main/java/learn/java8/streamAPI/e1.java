package learn.java8.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.*;

public class e1 {
	
	public static void main(String[] args){
		//p1();
		
		//p2();
		
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
				return s.toUpperCase();
			}).collect(Collectors.toList()));
		
	}

	private static void p2() {
		Stream<Integer> si1=Stream.of(1,2,3,4);
		Stream<Integer> si2=Stream.of(new Integer[]{1,2,3,4});
		
		Stream<String> str1 = Stream.generate(() -> {return "abc";});
		Stream<String> str2 = Stream.iterate("abc", (i) -> i);
		
		System.out.println(si1.collect(Collectors.toList()));
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		Stream<Integer> sequentialStream = myList.stream();

		Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
		System.out.print("High Nums greater than 90=");
		highNums.forEach(p -> System.out.print(p+" "));
	}

	private static void p1() {
		List<Integer> l=new ArrayList<>();
		l.add(10);l.add(11);l.add(9);
		System.out.println(l);
		int sum=l.stream().filter(i->i>=10).mapToInt(i->i).sum();
		System.out.println(sum);
	}
}
