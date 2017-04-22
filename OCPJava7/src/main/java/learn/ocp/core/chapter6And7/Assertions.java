package learn.ocp.core.chapter6And7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;

public class Assertions {

	public static void main(String[] args){
		s5();
		s1();
		System.out.println("I am BATMAN!!!");
		try{
			int x=0;
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		try{
			int x=1/0;
		}catch(Exception e){
			e.printStackTrace();
			e=new IOException();			
		}
		
		/*try{
			int x=0;
			InputStream i=new FileInputStream(new File("./src/main/resources/a.txt"));
			InputStreamReader ii=new InputStreamReader(i);
			ii.close();
		}catch(IOException e){
			e.printStackTrace();
			//e=new IOException();
		}*/
		try {
			s3();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void s1(){
		assert(1<0);
		System.out.println("Yo! All right!");
		assert(0>1):1;
		System.out.println("Yo! Error Man!");
	}
	public static void s2()throws SQLException,IOException{System.out.println("In s2");}
	
	public static void s3()throws SQLException,IOException{
		try{
			s2();
			System.out.println("in s3");
			s4();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}		
	}
	public static void s4()throws FileNotFoundException{System.out.println("In s4");}
	
	public static void s5(){
		try(BufferedReader r=new BufferedReader(new FileReader(new File("./src/main/resources/a.txt")))){
			String l=r.readLine();
			while(l!=null){
				System.out.println(l);
				l=r.readLine();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
