import java.util.HashMap;
import java.util.Scanner;

public class JesseProfit {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(),D=sc.nextInt();
		int arr[]=new int[N];
		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
		}
		int q[]=new int[D];
		HashMap<Integer, A> map=new HashMap<>();
		for(int i=0;i<D;i++){
			q[i]=sc.nextInt();
			A a=new A(0,N,N);
			map.put(q[i],a);
		}
		sc.close();
		
		for(int i=0;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				if(arr[i]>=arr[j])continue;
				int pf=arr[j]-arr[i];
				A a=map.get(pf);
				if(a!=null && a.z>j-i){
					a.x=i+1;a.y=j+1;a.z=j-i;
					//System.out.println(a.x+" "+a.y);
				}
			}
		}
		for(int i=0;i<D;i++){
			A a=map.get(q[i]);
			if(a.z!=N){
				System.out.println(a.x+" "+a.y);
			}else System.out.println(-1);
		}
	}
	

}

class A{
	int x,y,z;
	public A(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}