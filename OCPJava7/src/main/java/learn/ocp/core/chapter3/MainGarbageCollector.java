package learn.ocp.core.chapter3;

import java.util.Date;

public class MainGarbageCollector {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total JVM memory: " + rt.totalMemory());
		System.out.println("Before Memory = " + rt.freeMemory());
		Date d = null;
		for (int i = 0; i < 10000; i++) {
			d = new Date();
			d = null;
		}
		System.out.println("After Memory = " + rt.freeMemory());
		for (int j = 0; j < 20; j++) {
			waste();
			for (int i = 0; i < 10000; i++) {
				d = new Date();
				d = null;
			}
			rt.gc(); // an alternate to System.gc()
			System.out.println("After GC Memory Iteration"+j+":" + rt.freeMemory());
		}
	}
	public static void waste(){
		Date d;
		for (int i = 0; i < 10000; i++) {
			d = new Date();
			d = null;
		}
	}
}
