package learn.ocp.core.innerClass;

public class AnnoynomousInnerClass {
	
	public static void main(String args[]){
		Annoynomous a1=new Annoynomous();
		a1.m1();
		
	}
}

class PopCorn{
	void pop(){
		System.out.println("In PopCorn!");
	}
}
class Annoynomous{
	PopCorn p=new PopCorn(){
		int getN(){
			return 12;
		}
		void pop(){
			System.out.println("In Anoynomous PopCorn!");
		}
	};
	
	void m1(){
		p.pop();
	}
}
