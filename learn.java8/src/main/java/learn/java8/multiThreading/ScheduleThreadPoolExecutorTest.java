package learn.java8.multiThreading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		p1();
	}

	private static void p1() throws InterruptedException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

		// schedule to run after sometime
		System.out.println("Current Time = " + new Date());
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing THREAD-"+i);
			//scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
			//scheduledThreadPool.scheduleAtFixedRate(worker,1,10,TimeUnit.SECONDS);
			scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 1,TimeUnit.SECONDS);
		}

		// add some delay to let some threads spawn by scheduler
		Thread.sleep(30000);

		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Finished all threads");
	}

}

class WorkerThread implements Runnable {
	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Time = "
				+ new Date()+" "+command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End. Time = "
				+ new Date()+" "+command);
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}