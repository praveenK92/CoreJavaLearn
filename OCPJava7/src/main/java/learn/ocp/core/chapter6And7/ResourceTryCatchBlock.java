package learn.ocp.core.chapter6And7;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceTryCatchBlock {
		
	public static void main(String args[]){
		
		try(A a=new A();B b=new B();){
			System.out.println("I am here in A & B!");
			throw new IOException();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(C c=new C();D d=new D();){
			System.out.println("I am in C & D");
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}

class A implements Closeable{
	@Override
	public void close() throws IOException {
	}
}
class B implements Closeable{
	@Override
	public void close() throws IOException {
	}
}
class C implements AutoCloseable{
	@Override
	public void close() throws Exception {
	}
	
}
class D implements AutoCloseable{
	@Override
	public void close() throws Exception {
	}
}

class E{
	public void close() throws Exception {
	}
}