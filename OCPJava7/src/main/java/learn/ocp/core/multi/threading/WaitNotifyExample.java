package learn.ocp.core.multi.threading;

public class WaitNotifyExample {

	public static void main(String[] args){
		MyThread1 m1=new MyThread1();
		m1.start();
		
		synchronized (m1) {
			try{
				System.out.println("Waiting for MyThread1 to complete!");
				m1.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(m1.total);
		}
	}

}

class MyThread1 extends Thread{
	int total;
	
	public void run(){
		System.out.println("Inside MyThread1 Run Method");
		synchronized (this) {
			System.out.println("Adding 1 to 99");
			for(int i=1;i<100;i++){
				total+=i;
			}
			this.notify();
		}
	}
}