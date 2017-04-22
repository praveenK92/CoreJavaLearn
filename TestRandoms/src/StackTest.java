import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		//s.pop();
		s.push(1);
		A1 a1=new A1();
		System.out.println(a1.x+" "+a1.z+" "+a1.ch);
	}

}
class A1{
	int x;
	String z;
	char ch;
}