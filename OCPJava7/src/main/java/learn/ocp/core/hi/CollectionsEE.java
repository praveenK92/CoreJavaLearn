package learn.ocp.core.hi;

class Moosa{
	private int x;
	Moosa(){
		x=12;
	}
	Moosa(int z){
		x=z;
	}
	public int getX(){
		return x;
	}
	public void setX(int a){
		x=a;
	}
	public boolean equals(Object x){
		if(x instanceof Moosa && this.x==((Moosa)x).getX())
			return true;
		else
			return false;
	}
}

public class CollectionsEE {
	
	public static void main(String[] args) {
		Moosa m1=new Moosa(123);
		Moosa m2=new Moosa(123);
		
		System.out.println((m1==m2)+" "+m1.equals(null));
		
	}

}
