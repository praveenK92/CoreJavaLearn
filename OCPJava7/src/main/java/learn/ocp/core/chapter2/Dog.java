package learn.ocp.core.chapter2;

public class Dog extends Animal{
	{
		System.out.println("I am instance Dog");
	}
	static{
		System.out.println("He hei I am static Dog");
	}
	public Dog(){
		//super("FROM DOG sIMPLE");
		this("coming from simple");
		Dog();
		System.out.println("In Dog simple");
	}
	public Dog(String x){
		System.out.println("In Dog Parameterized:"+x);
	}
	static void Dog(){
		System.out.println("In Dog Method");
	}
	
	public static void eat() {
		System.out.println("Just Like Dog Eats");
	}
	/*{
		System.out.println("I am instance2 Dog");
	}*/
}
