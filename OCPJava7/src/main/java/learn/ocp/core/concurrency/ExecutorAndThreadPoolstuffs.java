package learn.ocp.core.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class ExecutorAndThreadPoolstuffs {

	public static void main(String[] args) {
		Callable<Integer> c1=new MyCallable();
		ExecutorService e1=Executors.newCachedThreadPool();
		Future<Integer> f1=e1.submit(c1);
		try {
			int ans=f1.get();
			System.out.println(ans);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		e1.shutdownNow();
	}

}
class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int count=ThreadLocalRandom.current().nextInt(11);
		return count;
	}
	
}