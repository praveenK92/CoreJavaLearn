import java.util.Scanner;

public class B {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double dis,tot;
		System.out.println("Enter total cost:");
		tot=sc.nextDouble();
		System.out.println("Enter discounted cost");
		dis=sc.nextDouble();
		double d=dis/tot;
		System.out.println("Input everyone's share:");
		String str[]={"Flat's ","Praveen's ","Boddu's ","Bindal's ",
				"Shashank's ","Nikhil's "};
		int n=str.length;
		double expend[]=new double[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter "+str[i]+"share");
			expend[i]=sc.nextDouble();
		}
		double res[]=new double[n],totVerify=0;
		for(int i=0;i<n;i++){
			res[i]=d*expend[i];
			totVerify+=res[i];
			System.out.println(str[i]+"expenditure is: "+Math.round(res[i]));			
		}
		System.out.println(totVerify+" "+dis+" "+(totVerify==dis));
		System.out.println("For Our Individual Calculation:"+Math.round(totVerify-res[0])
		+" "+Math.round(dis-res[0]));
	}
}