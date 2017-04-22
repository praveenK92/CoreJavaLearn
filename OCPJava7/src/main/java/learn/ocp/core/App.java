package learn.ocp.core;

public class App {
	static final A1 a1=new A1("Itachi");
    public static void main( String[] args ){
    	System.out.println(a1+" "+a1.x);
    	a1.x="Sasuke";
    	System.out.println(a1+" "+a1.x);
    	
    	Coffee c=new Coffee();
    	c.cs=CoffeeSize.BIG;
    	System.out.println(c.cs.ordinal()+" "+c.cs+" name:"+c.cs.name());
    }
}
class A1{
	String x;
	public A1(String x) {
		this.x = x;
	}
	/*@Override
	public String toString() {
		return "A1 [x=" + x + "]";
	}*/
	
}
enum CoffeeSize{BIG,MEDIUM,NORMAL}
class Coffee{
	CoffeeSize cs;	
}