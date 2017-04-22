package learn.ocp.core.chapter6And7;

import java.io.IOException;

public class SuppressedExceptions {
	public static void main(String args[]){
		
		try(A1 a1=new A1("a1");A1 a2=new A1("a2");){
			System.out.println("try");
		}catch(Exception e){
			System.err.println(e.getMessage());
			for(Throwable t:e.getSuppressed()){
				System.err.println("Suppressed: "+t);
			}
		}
		
	}
}

class A1 implements AutoCloseable{
	String n;
	A1(String x){
		n=x;
	}

	@Override
	public void close() throws IOException {
		throw new IOException("I am A1: "+n);
	}
	
}
