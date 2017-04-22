package learn.ocp.core.chapter4;

public class MainJavaOperators {
	private static final String a1="as";
	
	public static void main(String[] args) {
		String a=null;
		String b="";
		System.out.println(a instanceof String);
		System.out.println(b instanceof String);
		int x=2,y=3;
		if(y<x++ | ++y>x){
			System.out.println("x="+x+" y="+y);
		}
		int z=(x++ - ++x)-(y-++x);
		System.out.println(z+" "+x);
		byte b1=6&8;
		byte b2=7|9;
		byte b3=5^4;
		System.out.println(b1+" "+b2+" "+" "+b3);
		String x1="asds";
		switch(x1){
			case "":System.out.println("Here Babe1!");break;
			case a1:System.out.println("Here Babe2!");break;
			case "asd":System.out.println("Here Babe3!");break;
			case "asds":System.out.println("Here Babe4!");break;
			default:System.out.println("Yo babes!");
		}
		byte b11=12;
		switch(b11){
			case 23:System.out.println("Byte1!");break;
			//case 128:System.out.println("Byte 2");break;
		}
		
	}
}