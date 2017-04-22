package learn.ocp.core.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicVariables {

	public static void main(String[] args) {
		A a1=new A();
		Thread t1=new Threads(a1);
		Thread t2=new Threads(a1);
		
		t1.start();t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a1.getX());
		
		t1=new Threads(a1);
		Lock l=new ReentrantLock();
		l.tryLock();
		try{
			t1.start();
			t1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			l.unlock();
		}
		System.out.println(a1.getX());
		
		B b1=new B();
		t1=new Threads(b1);
		t2=new Threads(b1);
		Lock l1=new ReentrantLock();
		Lock l2=new ReentrantLock();
		boolean f1=l1.tryLock(),f2=l2.tryLock();
		try{
			if(f1)t1.start();
			if(f2)t2.start();
			t1.join();
			System.out.println("B's X="+b1.getX());
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			if(f1)l1.unlock();
			if(f2)l2.unlock();						
		}
		System.out.println("B's X="+b1.getX());
	}

}

class B extends A{
	int x=0;
	void incr(){
		x++;
	}
	int getX(){
		return x;
	}
}

class A{
	AtomicInteger x=new AtomicInteger(0);
	void incr(){
		x.incrementAndGet();
	}
	int getX(){
		return x.get();
	}
}

class Threads extends Thread{
	A a;
	public Threads(A a) {
		this.a=a;
	}
	
	public void run(){
		for(int i=0;i<1000;i++){
			a.incr();
		}
	};
}