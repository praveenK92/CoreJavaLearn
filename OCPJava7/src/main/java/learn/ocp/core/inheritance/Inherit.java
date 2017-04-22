package learn.ocp.core.inheritance;

public class Inherit{
	public static void main(String[] args) {
		A b=new B();
		C c=new C();
		b.show();
		//b.sa();
		c.show();
		
		
		
		
	}
	void show(A a){
		if(a instanceof B)System.out.println("Yo B!");
		else if(a instanceof C)System.out.println("Yo C!");
		a.show();
	}
	
}

class A{
	private void s(){
		System.out.println("In A:s");
	}
	void show(){
		System.out.println("In A");
	}
}
class B extends A{
	void sa(){
		System.out.println("sa");
		
	}
	public void show(){
		System.out.println("In B");
	}
}
class C extends A{
	@Override
	void show(){
		System.out.println("In C");
	}
}