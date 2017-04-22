package learn.ocp.core.chapter4;

class A {
}
public class B extends A {
	public static void main(String[] args) {
		A myA = new B();
		m2(myA);
		
		boolean b1=true,b2=false;
		if((b2=false)|21%5>2);
		if(b1 || b2==true);
		if(b1==true)
		System.out.println(b2);
		
	}

	public static void m2(A a) {
		if (a instanceof B)
			((B) a).doBstuff(); // downcasting an A reference
			// to a B reference
	}

	public static void doBstuff() {
		System.out.println("'a' refers to a B");
	}
}