import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Random {

	public static void main(String[] args) {
		/*ArrayList<ArrayList<Integer>> a=new ArrayList();
		int j=1;
		for(int i=0;i<5;i++){
			a.set(i, new ArrayList<Integer>());
			ArrayList<Integer> a1=a.get(i);
			for(int k=0;k<5;k++,j++){
				a1.add(j);
			}
		}*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ss[][]=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ss[i][j]=sc.nextInt();
			}
		}
		int x=zombieCluster1(ss);
		System.out.println(x);
		//ArrayList<Integer> b=spiralOrder(a);
		//System.out.println(b);
	}
	
	/*public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int n2=a.size(),n1=0,m1=0,m2=a.get(0).size();
		 while(n1<n2 && m1<m2){
		        for(int i=m1;i<=m2;i++){
		        	result.add(a.get(n1).get(i));
		        }n1++;
		        for(int i=n1;i<=n2;i++){
		        	result.add(a.get(i).get(i));
		            res[r++]=arr[i][m2];
		        }m2--;
		        for(int i=m2;i>=m1;i--){
		            res[r++]=arr[n2][i];
		        }n2--;
		        for(int i=n2;i>=n1;i--){
		            res[r++]=arr[i][m1];
		        }m1++;
		    }
		 
		 return result;
	}*/
	static int zombieCluster1(int[][] adj) {
		int n=adj.length;
		boolean vis[]=new boolean[n];
		for(int i=0;i<n;i++){
			vis[i]=false;
		}
		
		int ans=0;
		for(int i=0;i<n;i++){
			if(!vis[i]){
				ans++;
				Stack<Integer> s=new Stack<>();
				s.push(i);
				while(!s.isEmpty()){
					int v=s.pop();
					vis[v]=true;
					System.out.println(v+" popped");
					
					for(int j=0;j<n;j++){
						System.out.println(v+" "+j+" :"+adj[v][j]);
						if(j!=v && !vis[j] && adj[v][j]==1){
							s.push(j);
							System.out.println(v+" "+j);
						}
					}
				}
			}
		}			
		return ans;
    }
	static int zombieCluster(String[] zombies) {
		int n=zombies.length;
		int adj[][]=new int[n][n];
		boolean vis[]=new boolean[n];
		for(int i=0;i<n;i++){
			vis[i]=false;
			char ch[]=zombies[i].toCharArray();
			for(int j=0;j<n;j++){
				adj[i][j]=ch[j]-'0';
			}
		}
		
		int ans=0;
		Stack<Integer> s=new Stack();		
		for(int i=0;i<n;i++){
			if(!vis[i]){
				ans++;
				s.push(i);
				while(!s.isEmpty()){
					int v=s.pop();
					vis[v]=true;
					for(int j=0;j<n;j++){
						if(j!=v && !vis[v] && adj[v][j]==1){
							s.push(j);
							System.out.println(v+" "+j);
						}
					}
				}
			}
		}			
		return ans;
    }
}
