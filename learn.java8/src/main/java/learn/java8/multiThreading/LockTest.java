package learn.java8.multiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args){
		Resource r=new Resource();
		ConcurrencyLockExample c1=new ConcurrencyLockExample(r);
		ConcurrencyLockExample c2=new ConcurrencyLockExample(r);
		Thread t1=new Thread(c1,"Sasuke");
		Thread t2=new Thread(c2,"Naruto");
		t1.start();t2.start();
	}

}

class ConcurrencyLockExample implements Runnable {
	private Resource resource;
	private Lock lock;
	public ConcurrencyLockExample(Resource r) {
		this.resource = r;
		this.lock = new ReentrantLock();
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if (lock.tryLock(10, TimeUnit.SECONDS)){
				resource.doSomething(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// release lock
			lock.unlock();
		}
		resource.doLogging(Thread.currentThread().getName());
	}
}

class SynchronizedLockExample implements Runnable {
	private Resource resource;
	public SynchronizedLockExample(Resource r) {
		this.resource = r;
	}
	@Override
	public void run() {
		synchronized (resource) {
			resource.doSomething(Thread.currentThread().getName());
		}
		resource.doLogging(Thread.currentThread().getName());
	}
}

class Resource {
	public void doSomething(String name) {
		System.out.println("Do Something! "+name);
	}

	public void doLogging(String name) {
		System.out.println("Logging For: "+name);
	}
}