package learn.ocp.core.multi.threading;

public class PrintNumbers {
	public static void main(String[] args) {
		/*A1 t = new A1();
		t.setName("Pra");

		t.start();*/
		StringBuffer s=new StringBuffer("A");
		System.out.println(s);
		A2 t1=new A2(s);
		A2 t2=new A2(s);
		A2 t3=new A2(s);
		t1.start();t2.start();t3.start();
		
	}

}
class A2 extends Thread{
	StringBuffer sb;
	A2(StringBuffer s){
		sb=s;
	}
	@Override
	public void run(){
		synchronized(sb){
			for(int i=0;i<5;i++){
				System.out.println(getName()+": "+sb.toString());
			}
			if(sb.toString().equals("A")){
				sb.append("B");
			}else if(sb.toString().equals("AB")){
				sb.append("C");
			}
		}
	}
}
class A1 extends Thread {
	static int i = 1;

	@Override
	public void run() {
		while (i <= 100) {
			try {
				System.out.println(getName() + " : " + i);
				if(i%10==0){
					System.out.println("I am at 10x: "+i);
					}
				i++;
				sleep(1);
			} catch (InterruptedException e) {
				System.out.println("Error: " + e);

			}
		}
	}
}