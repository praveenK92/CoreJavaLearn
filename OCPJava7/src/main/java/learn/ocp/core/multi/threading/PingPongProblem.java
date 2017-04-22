package learn.ocp.core.multi.threading;


public class PingPongProblem {

	public static void main(String[] args) {
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		t1.setName("Odd");
		t2.setName("Even");
		t1.start();
		t2.start();
	}

}
class MyThread extends Thread{
	static Integer i=1;
	static boolean isOdd=true;
	static String s="";
	@Override
	public void run(){
		int i=0;
		while(i<=10){
			synchronized(s){
				i++;
				try{
					//System.out.println(this.getName()+" : "+i++);
					if(isOdd){
						isOdd=false;
						System.out.println(this.getName()+" : PING");
						s.wait();
					}
					else{
						isOdd=true;
						System.out.println(this.getName()+" : PONG");
						s.notify();
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}