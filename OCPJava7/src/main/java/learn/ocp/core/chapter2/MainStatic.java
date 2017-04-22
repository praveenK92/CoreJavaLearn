package learn.ocp.core.chapter2;

public class MainStatic{
	static int x;
	public MainStatic() {
		x++;
		//this.x++;
	}
	public static void main(String a[]) {
		for(int i=0;i<4;i++)
			new MainStatic();
		MainStatic a1=new MainStatic();
		System.out.println("MainStatic.x="+MainStatic.x+"\nx="+x+"\na1.x="+a1.x);
		
		Animal a2[]={new Animal(),new Dog(),new Animal()};
		for(Animal a3:a2){
			a3.eat();
		}
		Dog.eat();
	}
}
