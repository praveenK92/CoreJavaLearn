package learn.java8.multiThreading;

public class ThreadDeadlock {
	
	public static void main(String[] args) throws InterruptedException {		
		testObject o1=new testObject("Test-1");
		testObject o2=new testObject("Test-2");
		testObject o3=new testObject("Test-3");		
		
		Thread t1 = new Thread(new SyncThread(o1, o2), "t1");
		Thread t2 = new Thread(new SyncThread(o2, o3), "t2");
		Thread t3 = new Thread(new SyncThread(o3, o1), "t3");
		
		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();
		
	}

}

class SyncThread implements Runnable {
	private Object obj1;
	private Object obj2;
	
	public SyncThread(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + obj1);
		synchronized (obj1) {
			System.out.println(name + " acquired lock on " + obj1);
			work();
			System.out.println(name + " acquiring lock on " + obj2);
			synchronized (obj2) {
				System.out.println(name + " acquired lock on " + obj2);
				work();
			}
			System.out.println(name + " released lock on " + obj2);
		}
		System.out.println(name + " released lock on " + obj1);
		System.out.println(name + " finished execution.");
	}

	private void work() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class testObject{
	private String name;

	public testObject(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "testObject [name=" + name + "]";
	}
}