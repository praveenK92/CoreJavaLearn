package learn.ocp.core.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AutoboxingStuff {
	static Integer xx;
	static int yy; 
	
	public static void main(String[] args){
		//BoxingStuffs();
		//ArrayListSortStuff();
		//SetStuff();
		
	}
	static void SetStuff(){
		Set a=new HashSet();
		a.add("a");a.add("b");a.add("a");a.add(new A(32,"efgae"));
		System.out.println(a);
		
		Set<A> a2=new HashSet<>();
		a2.add(new A(12,"Pikachu"));
		a2.add(new A(19,"cHIKORITA"));
		a2.add(new A(12,"Pikachu"));
		System.out.println(a2);
		
		Set<A> a1=new TreeSet<>();
		a1.add(new A(12,"Pikachu"));
		a1.add(new A(19,"cHIKORITA"));
		a1.add(new A(12,"Pikachu"));
		a1.add(new A(19,"Charlizard"));
		System.out.println(a1);
	}
	static void ArrayListSortStuff(){
		ArrayList<String> s1=new ArrayList<>();
		s1.add("aman");s1.add("AMan");
		s1.add("Pallu");s1.add("Praveen");s1.add("Pooja");
		s1.add("Megha");s1.add("Menka");
		System.out.println(s1);
		Collections.sort(s1);
		System.out.println(s1);
		
		ArrayList<A> s2=new ArrayList<>();
		s2.add(new A(5,"Menka"));
		s2.add(new A(1,"Megha"));
		s2.add(new A(2,"Praveen"));
		s2.add(new A(2,"Pallu"));
		s2.add(new A(-8,"Pooja"));
		System.out.println(s2);
		A a2[]=new A[s2.size()];
		a2=s2.toArray(a2);
		Arrays.sort(a2);
		//Collections.sort(s2);
		Collections.sort(s2,new A1());
		System.out.println(s2);
		for(int i=0;i<a2.length;i++){
			System.out.print(a2[i]+",");
		}
	}
	
	static void BoxingStuffs(){
		Integer x=new Integer("234");
		x++;
		System.out.println(x);
		Integer x1=123;
		Integer x2=x1;
		x1++;
		System.out.println(x2+" "+x1+" "+(x1-1==x2));
		Integer x3=-129;
		Integer x4=-129;
		System.out.println("x3==x4 when x<128 x>-129"+(x3==x4)+" "+(x3!=x4));
		System.out.println("x3.equals(x4) "+x3.equals(x4));
		doso(yy);
		// throws nullpointer
		try{
			doso(xx);			
		}catch(NullPointerException e){
			e.printStackTrace();
			
		}
	}
	static void doso(int x){
		System.out.println(x+10);		
	}
	
}

class A1 implements Comparator<A>{

	@Override
	public int compare(A o1, A o2) {
		int a1=o1.getX(),a2=o2.getX();
		if(a1>a2)return -1;
		else if(a1<a2)return 1;
		else return o1.getName().compareTo(o2.getName()); 
	}
	
}

class A implements Comparable<A>{
	private int x;
	private String name;
	
	@Override
	public String toString() {
		return "x=" + x + " name=" + name;
	}

	public A(int x, String name) {
		this.x = x;
		this.name = name;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof A){
			A a=(A)o;
			if(a.getX()==this.x && a.getName().equals(this.name))return true;
		}
		return false;
		
	}
	@Override
	public int hashCode() {
		return x%10;
	}
	
	@Override
	public int compareTo(A o) {
		if(x>o.x)return 1;
		else if(x<o.x)return -1;
		else return name.compareTo(o.getName());
	}
}
