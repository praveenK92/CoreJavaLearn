package learn.ocp.core.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {

	public static void main(String[] args) {
		//GenericListProblems();
		GeneriCClassStuffs();
	}
	static void GeneriCClassStuffs(){
		List<Animal> animals=new ArrayList<>();
		animals.add(new Animal());
		animals.add(new Dog());
		animals.add(new Cat());
		
		GenericStuff<Animal> ga=new GenericStuff<>(animals,animals.size());
		System.out.println(ga.getFree());
		ga.add(new Dog());
		animals.add(new Animal());
		System.out.println(ga.getList());
		
		List<Dog> dogs=new ArrayList<Dog>();
		dogs.add(new Dog());dogs.add(new Dog());dogs.add(new Dog());
		
		GenericDouble<Animal,Dog> ad=new GenericDouble<>(animals,dogs);
		System.out.println(ad);
		
		GenericSome gs1=new GenericSome();
		gs1.makeSome(new Animal());
		gs1.makeSomeStuff(dogs);
	}
	static void GenericListProblems(){
		List<Integer> l1=new ArrayList<>();
		l1.add(123);l1.add(567);l1.add(67856);
		AddSome(l1);
		System.out.println(l1+""+l1.size());
		for(int i:l1){
			System.out.print(","+i);
		}
		System.out.println("");
		List l2=new ArrayList();
		l2.add(646);
		int x=(int) l2.get(0);
		System.out.println(x);
		/*Dog d[]=new Dog[5];
		for(int i=0;i<5;i++){
			d[i]=new Dog();
		}
		ArrayStuff(d);
		for(int i=0;i<5;i++){
			d[i].cleanUp();
		}*/
		List<Animal> an=new ArrayList<Animal>();
		an.add(new Animal());
		an.add(new Dog());
		DoSomeAnimal(an);
		System.out.println("Take 2");
		List<Dog> an2=new ArrayList<>();
		an2.add(new Dog());
		an2.add(new Dog());
		DoSomeAnimal(an2);
	}
	static void AddSome(List l){
		l.add(987);
		//l.add("Asan");
	}
	static void DoSomeAnimal(List<? extends Animal> l){
		Iterator<? extends Animal> i=l.iterator();
		while(i.hasNext()){
			Animal a=i.next();
			a.cleanUp();
		}
	}
	static void ArrayStuff(Animal[] an){
		an[0]=new Dog();
		//an[1]=new Cat();
	}
}


class GenericSome{
	
	public <T> void makeSome(T t){
		List<T> tt=new ArrayList<>();
		tt.add(t);
		System.out.println(tt);
	}
	public <T> void makeSomeStuff(List<T> t){
		List<T> tt=t;
		System.out.println(tt);
	}
}

class GenericDouble<A,B>{
	private List<A> aa;
	private List<B> bb;
	
	public GenericDouble(){
		aa=new ArrayList<A>();
		bb=new ArrayList<B>();
	}
	public GenericDouble(List<A> aa, List<B> bb) {
		this.aa = aa;
		this.bb = bb;
	}
	@Override
	public String toString() {
		return "GenericDouble [aa=" + aa + ", bb=" + bb + "]";
	}
	public List<A> getAa() {
		return aa;
	}
	public void setAa(List<A> aa) {
		this.aa = aa;
	}
	public List<B> getBb() {
		return bb;
	}
	public void setBb(List<B> bb) {
		this.bb = bb;
	}
}

class GenericStuff<T>{
	private List<T> list;
	private int s;
	
	public T getFree(){
		return list.remove(0);
	}
	public void add(T e){
		list.add(e);
	}
	
	public GenericStuff() {
		this.s = 10;
		this.list = new ArrayList<T>(s);
	}
	public GenericStuff(List<T> list, int s) {
		this.list = list;
		this.s = s;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	
}

class Animal{
	
	@Override
	public String toString(){
		return "Animal []";
	}
	void cleanUp(){
		System.out.println("In ANIMAL");
	}
}
class Dog extends Animal{
	
	@Override
	public String toString() {
		return "Dog []";
	}
	void cleanUp(){
		System.out.println("In DOG");
	}
}
class Cat extends Animal{
	
	@Override
	public String toString() {
		return "Cat []";
	}
	void cleanUp(){
		System.out.println("In CAT");
	}
}