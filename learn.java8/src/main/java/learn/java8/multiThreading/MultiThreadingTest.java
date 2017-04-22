package learn.java8.multiThreading;

public class MultiThreadingTest {

	public static void main(String[] args) throws InterruptedException {
		// p1();
		// p2();
		p3();
	}

	private static void p3() throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println("Processing count="+pt.getCount());
	}

	private static void p2() {
		Thread t1 = new Thread(new MyRunnable(), "t1");
		Thread t2 = new Thread(new MyRunnable(), "t2");
		Thread t3 = new Thread(new MyRunnable(), "t3");

		t1.start();

		// start second thread after waiting for 2 seconds or if it's dead
		try {
			t1.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();

		// start third thread only when first thread is dead
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t3.start();

		// let all threads finish execution before finishing main thread
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("All threads are dead, exiting main thread");
	}

	private static void p1() {
		Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
		Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
		System.out.println("Starting Runnable threads");
		t1.start();
		t2.start();
		System.out.println("Runnable Threads has been started");
		Thread t3 = new MyThread("t3");
		Thread t4 = new MyThread("t4");
		System.out.println("Starting MyThreads");
		t3.start();
		t4.start();
		System.out.println("MyThreads has been started");
	}
}

class ProcessingThread implements Runnable {
	private int count;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count++;
		}
	}

	public int getCount() {
		return this.count;
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread started:::" + Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::" + Thread.currentThread().getName());
	}

}

class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("MyThread - START " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			// Get database connection, delete unused data from DB
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(1000);
	}

}

class HeavyWorkRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Doing heavy processing - START " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			// Get database connection, delete unused data from DB
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Doing heavy processing - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(1000);
	}

}