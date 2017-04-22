package learn.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class CollectionsTest {

	public static void main(String[] args) {
		TreeMap<String, Integer> t1 = new TreeMap<>();
		LinkedHashMap<String, Integer> l1 = new LinkedHashMap<>();
		Hashtable<String, String> h1 = new Hashtable<>();
		// p1();
		// p2();
		// p3();
		// p4();
		// p5();
		// p6();
		// p7();
		// p8();
		// p9();

		HashSet<Integer> hashSet = new HashSet<Integer>();

		hashSet.add(2);
		hashSet.add(5);
		hashSet.add(1);
		hashSet.add(null);
		// will throw null pointer
		hashSet.add(999);
		hashSet.add(10);
		hashSet.add(10);
		hashSet.add(11);
		hashSet.add(9);
		hashSet.add(10);
		hashSet.add(000);
		hashSet.add(999);
		hashSet.add(0);
		
		Iterator<Integer> it = hashSet.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}

	}

	private static void p9() {
		ArrayList<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				// myList.remove(value);
				myList.add("12");
		}
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
			if (myList.get(i).equals("3")) {
				myList.remove(i);
				// i--;
				myList.add("6");
			}
		}
		System.out.println(myList);

		HashMap<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}
	}

	private static void p8() {
		List<String> myList = new CopyOnWriteArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3")) {
				myList.remove("4");
				myList.add("6");
				myList.add("7");
			}
		}
		System.out.println("List Size:" + myList.size());

		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("1")) {
				myMap.remove("3");
				myMap.put("4", "4");
				myMap.put("5", "5");
			}
		}

		System.out.println("Map Size:" + myMap.size());
	}

	private static void p7() {
		// ConcurrentHashMap
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: " + myMap);
		Iterator<String> it = myMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("3"))
				myMap.put(key + "new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: " + myMap);

		// HashMap
		myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("HashMap before iterator: " + myMap);
		Iterator<String> it1 = myMap.keySet().iterator();

		while (it1.hasNext()) {
			String key = it1.next();
			if (key.equals("3"))
				// myMap.put(key + "new", "new3");
				myMap.put(key, "new3");
			// break;
		}
		System.out.println("HashMap after iterator: " + myMap);
	}

	private static void p6() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Pankaj");
		names.add("David");
		names.add("Lisa");
		names.add("Meghna");

		List<String> first2Names = names.subList(0, 2);

		System.out.println(names + " , " + first2Names);

		names.set(1, "Kumar");
		// check the output below. 🙂
		System.out.println(names + " , " + first2Names);

		first2Names.add("Megan"); // this is fine
		System.out.println(names + " , " + first2Names); // this is fine

		// Let's modify the list size and get ConcurrentModificationException
		names.add("Deepak");
		System.out.println(names + " , " + first2Names); // this line throws
															// exception
	}

	private static void p5() {
		ArrayList<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			ints.add(i);

		ListIterator<Integer> lit = ints.listIterator(ints.size());

		while (lit.hasPrevious()) {
			int x = lit.previous();
			System.out.print(x + ", ");
			if (x == 5) {
				lit.remove();
				lit.add(20);
			}
		}
		System.out.println("\n" + ints);
	}

	private static void p4() {
		ArrayList<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			ints.add(i);

		Iterator<Integer> it = ints.iterator();
		// simple iteration
		while (it.hasNext()) {
			int x = (int) it.next();
			System.out.print(x + ", ");
		}
		System.out.println("\n" + ints);

		// modification of list through iterator
		it = ints.iterator();
		while (it.hasNext()) {
			int x = (int) it.next();
			if (x % 2 == 0)
				it.remove();
		}
		System.out.println(ints);

		// changing list structure while iterating
		it = ints.iterator();
		while (it.hasNext()) {
			int x = (int) it.next();
			// ConcurrentModificationException here
			if (x == 5)
				ints.add(20);
		}
	}

	private static void p3() {
		List<String> stocks = new ArrayList<>();
		stocks.add("Google");
		stocks.add("Apple");
		stocks.add("Microsoft");
		stocks.add("Facebook");

		Consumer<Object> consumer = new CollectionsTest().new MyConsumer();

		stocks.forEach(consumer);
		System.out.println("Done Part 1");
		// lambda style
		stocks.forEach(x -> {
			System.out.println("Processed " + x);
		});
	}

	class MyConsumer implements Consumer<Object> {

		@Override
		public void accept(Object t) {
			System.out.println("Processing " + t);
		}
	}

	private static void p2() {
		ArrayList<String> letters = new ArrayList<>();

		// add example
		letters.add("A");
		letters.add("C");
		letters.add("D");

		// let's insert B between A and C
		letters.add(1, "B");
		System.out.println(letters);

		List<String> list = new ArrayList<String>();
		list.add("E");
		list.add("H");

		// appending list elements to letters
		letters.addAll(list);
		System.out.println(letters);

		// clear example to empty the list
		list.clear();

		list.add("F");
		list.add("G");

		// inserting list inside letters to get right sequence
		letters.addAll(5, list);
		System.out.println(letters);

		// contains example
		System.out.println("Letters list contains E ? " + letters.contains("E"));
		System.out.println("Letters list contains Z ? " + letters.contains("Z"));

		// ensureCapacity example, it's ArrayList method, so object should be
		// defined like below.
		ArrayList<String> tempList = new ArrayList<>();
		tempList.ensureCapacity(1000);

		// get example
		String e = letters.get(4);
		System.out.println("Letter at 5th place: " + e);

		// tempList is empty?
		System.out.println("tempList is empty ? " + tempList.isEmpty());

		// indexOf example
		System.out.println("First index of D = " + letters.indexOf("D"));
		System.out.println("Last index of D = " + letters.lastIndexOf("D"));

		// remove examples
		System.out.println(letters);
		String removed = letters.remove(3);
		System.out.println("After removing '" + removed + "' letters contains " + letters);

		// remove first occurrence of H
		boolean isRemoved = letters.remove("H");
		System.out.println("H removed? " + isRemoved + ". Letters contains " + letters);
		System.out.println("list contains " + list);

		// remove all matching elements between letters and list
		letters.removeAll(list);
		System.out.println(letters);

		// retainAll example
		list.clear();
		list.add("A");
		list.add("B");
		list.add("C");
		letters.retainAll(list);
		System.out.println("letters elements after retainAll operation: " + letters);

		// size example
		System.out.println("letters ArrayList size = " + letters.size());

		// set example
		letters.set(2, "D");
		System.out.println(letters);

		// toArray example
		String[] strArray = new String[letters.size()];
		strArray = letters.toArray(strArray);
		System.out.println(Arrays.toString(strArray));
	}

	private static void p1() {
		List<Integer> vowels = new ArrayList<>();

		// Java ArrayList constructor with initial capacity
		for (int i = 0; i < 10; i++)
			vowels.add(i);
		vowels.add(11);

		// Creating my list from different collection source
		List<Integer> myList = new ArrayList<>(vowels);
		System.out.println(myList);
	}
}