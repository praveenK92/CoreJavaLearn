import java.util.Scanner;

public class DivideBy7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int q=sc.nextInt();
		
		for(int i=0;i<q;i++){
			int l=sc.nextInt(),r=sc.nextInt(),a,b,n;
			StringBuilder x=new StringBuilder(str.substring(l-1, r));
			n=x.length();
			while(n>=2){
				a=2*(x.charAt(n-1)-'0');
				b=x.charAt(n-2)-'0';
				if(b>=a){
					char ch='0';
					x.setCharAt(n-2, ch);
					n--;
					continue;
				}
			}
			
		}
		sc.close();
	}

}
