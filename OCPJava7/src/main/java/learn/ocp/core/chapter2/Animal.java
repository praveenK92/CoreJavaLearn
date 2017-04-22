package learn.ocp.core.chapter2;

public class Animal {
	{
		System.out.println("I am instance Animal");
	}
	static{
		System.out.println("He hei I am static Animal");
	}
	public Animal() {
		System.out.println("In Animal simple");
	}
	public Animal(String x){
		System.out.println("In Animal Parameterized:"+x);
	}

	public static void eat(){
		System.out.println("Just Like Animals eat");
	}
	/*{
		System.out.println("I am instance2 Animal");
	}*/
}
