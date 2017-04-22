import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//public class TestClass {
public class PetroCycles {
	static ArrayList<Edge> vx[];
	static ArrayList<Ans> sol;

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		vx=new ArrayList[n];
		for(int i=0;i<n;i++){
			vx[i]=new ArrayList<Edge>();
		}
		
		for(int i=0;i<m;i++){
			int x=sc.nextInt(),y=sc.nextInt();
			Edge xx=new Edge(x-1,y-1,i+1);
			vx[x-1].add(xx);
			vx[y-1].add(xx);
		}
		sc.close();
		sol=new ArrayList<Ans>();
		
		/*for(int i=0;i<n;i++){
			System.out.println(i+" "+vx[i]);
		}*/
		
		for(int i=0;i<n;i++){
			
			ArrayList<Edge> a=vx[i];
			//Edge[] aa=a.toArray(new Edge[a.size()]);
			if(a==null || a.size()<1){
				continue;
			}
			
			for(int ai=0;ai<a.size();ai++){
				Edge aa=a.get(ai);
				if(aa.f)continue;
				
				int j=aa.getV(i);
				ArrayList<Edge> b=vx[j];
				boolean fl=false;
				
				for(Edge bb:b){
					if(bb.f)continue;
					
					int k=bb.getV(j);
					ArrayList<Edge> c=vx[k];
					for(Edge cc:c){
						if(cc.getV(k)==i && !cc.f){
							Ans an=new Ans(aa.no,bb.no,cc.no);
							sol.add(an);
							aa.f=true;bb.f=true;cc.f=true;
							
							c.remove(cc);c.remove(bb);
							b.remove(bb);b.remove(aa);
							
							//a.remove(cc);a.remove(aa);
							
							fl=true;
							break;
						}
					}
					if(fl)break;
				}
			}
		}
		System.out.println(sol.size());
		Iterator<Ans> si=sol.iterator();
		while(si.hasNext()){
			Ans a=si.next();
			System.out.println(a);
		}
	}

}
class Edge{
	int u,v,no;
	boolean f=false;
	public Edge(int u,int v,int no) {
		this.no = no;
		this.v = v;
		this.u=u;
	}
	public int getV(int x){
		if(x==u)return v;
		else return u;
	}
	@Override
	public String toString() {
		return u+","+v+"="+no;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Edge other = (Edge) obj;
		if (no == other.no && v==other.no && u==other.no)
			return true;
		else
			return false;
	}
	
}
class Ans{
	int x,y,z;
	public Ans(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return x+" "+y+" "+z;
	}	
}