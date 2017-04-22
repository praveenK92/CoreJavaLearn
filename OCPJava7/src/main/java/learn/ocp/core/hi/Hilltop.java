package learn.ocp.core.hi;
import java.lang.*;
public class Hilltop {
	static int s;
	int x;
	{x=12;int x2=199;System.out.println("instance block");}
	Hilltop(){
		x+=122;
		System.out.println("here cons");
	}
	public static void main(String[] args) {
		char ch=(char)(65534);
		Integer n=new Integer(ch);
		System.out.println(ch);
		Hilltop a=new Hilltop();
		System.out.println(a.xx+" "+n);
	}
	int xx;
}