package learn.ocp.core.innerClass;

import learn.ocp.core.innerClass.Outer1.Inner1;

public class InnerClassStuff {

	public static void main(String[] args) {
		Outer1 o1=new Outer1();
		o1.callInM1();
		
		Outer1.Inner1 in1=o1.new Inner1();
		in1.innerM("Nishi is 43");
		in1.callM2();
		o1.methodInnerClass();
		
	}
	
}

class Outer2{
	
	private static class Inner2{
		public void call(){
			System.out.println("In Inner2!");
		}
	}
}

class Outer1{
	private int x=1;
	
	void callInM1(){
		Inner1 i=new Inner1();
		i.innerM("Surabhi is 26");
	}
	
	void methodInnerClass(){
		int x=23;
		final int y=45;
		
		final class Inner2{
			void read(){
				System.out.println("I am reading! "+Outer1.this.x);
			}
			void read2(){
				System.out.println(y);
			}
		}
		Inner2 i=new Inner2();
		i.read();i.read2();
	}
	
	class Inner1{
		void innerM(String s){
			System.out.println(x+". Inner1 Method! "+s);
		}
		void callM2(){
			System.out.println("Address of inner Class: "+this);
			System.out.println("Address of current outer class: "+Outer1.this);
		}
	}
}