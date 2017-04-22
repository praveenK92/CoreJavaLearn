package learn.ocp.core.chapter6And7;

import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args){
		s1();
		//s2();
		//s3();
		try {
			s4();
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println("Never Gonna Reach Bitch!");		
	}
	private static void s1(){
		try{
			throw new ArithmeticException();
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage()+" in S1");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Friends: I will always be there for you!");
		}
	}
	private static void s2(){
		try{
			int a=0;int b=4/a;
			System.out.println("Won't run baby!"+a+" "+b);
		}finally{
			System.out.println("Finally Always Runs Bitches!");
		}
	}
	private static void s3(){
		System.out.println("In Error Method!");
		throw new Error();
	}
	private static void s4() throws MyException{
		System.out.println("In MyException Throw Method!");
		throw new MyException();
	}
}
class MyException extends Exception{
	private static final long serialVersionUID = 1L;
	
}