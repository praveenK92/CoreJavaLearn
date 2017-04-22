package learn.ocp.core.chapter10;

public class SingletonDesign {
	
	public static void main(String[] args) {
		SingletonEager se1=SingletonEager.getInstance();
		se1.m1();
		SingletonEager se2=SingletonEager.getInstance();
		se2.m1();
		se1.m1();
		SingletonLazy sl=SingletonLazy.getInstance();
		sl.m1();sl.m1();
		SingletonLazy sl2=SingletonLazy.getInstance();
		sl2.m1();
		sl.m1();
	}

}
class SingletonEager{
	private int count=0;
	private static final SingletonEager instance=new SingletonEager();
	
	private SingletonEager(){}
	
	public static SingletonEager getInstance(){
		return instance;
	}
	
	public void m1(){
		count++;
		System.out.println("Eager: "+count);
	}
}

class SingletonLazy{
	private int count=10;
	private static SingletonLazy instance;;
	
	private SingletonLazy(){}
	
	public static SingletonLazy getInstance(){
		if(instance==null){
			instance=new SingletonLazy();
		}
		return instance;
	}
	
	public void m1(){
		count++;
		System.out.println("Lazy "+count);
	}
}