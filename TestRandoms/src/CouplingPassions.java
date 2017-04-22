import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CouplingPassions {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String, Integer> leis=new HashMap<>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			int m=sc.nextInt();
			for(int j=0;j<m;j++){
				String x=sc.next();
				leis.put(x, 1);
			}
		}
		n=sc.nextInt();
		City cc[]=new City[n];
		for(int i=0;i<n;i++){
			cc[i]=new City();
			cc[i].name=sc.next();;
			cc[i].la=sc.nextDouble();
			cc[i].lo=sc.nextDouble();
			int m=sc.nextInt();
			for(int j=0;j<m;j++){
				String x=sc.next();
				if(leis.get(x)!=null){
					cc[i].ll.add(x);
				}
			}
			Collections.sort(cc[i].ll);
		}
		
		
		int sol[]=new int[3];
		double dist=0;
		for(int i=0;i<n;i++){
			City c1=cc[i];
			for(int j=i+1;j<n;j++){
				City c2=cc[j];
				int ans=c1.diffLL(c2.ll);
				if(ans>sol[2]){
					sol[0]=i;sol[1]=j;sol[2]=ans;
					dist=City.dist(c1, c2);
				}else if(ans==sol[2]){
					double d=City.dist(c1, c2);
					if(d<dist){
						sol[0]=i;sol[1]=j;sol[2]=ans;
						dist=d;
					}
				}
			}
		}
		
		List<String> ans=new ArrayList<>();
		ans.add(cc[sol[0]].name);
		ans.add(cc[sol[1]].name);
		Collections.sort(ans);
		
		System.out.print(ans.get(0)+" "+ans.get(1));
		sc.close();
	}
}
class City{
	double la=0.0,lo=0.0;
	String name="";
	List<String> ll=new ArrayList<>();
	
	int diffLL(List<String> x){
		int n=ll.size(),m=x.size(),l=Math.min(n, m),ans=0;
		
		for(int i=0;i<l;i++){
			if(ll.get(i).equals(x.get(i))){
				ans++;
			}else{
				ans+=2;
			}
		}
		ans+=Math.abs(n-m);
		return ans;
	}
	public static double dist(City c1,City c2){
		double EARTH_RADIUS = 6371;//in km
		double point1_lat_in_radians  = Math.toRadians(c1.la);
		double point2_lat_in_radians  = Math.toRadians(c2.la );
		double point1_long_in_radians  = Math.toRadians( c1.lo );
		double point2_long_in_radians  = Math.toRadians( c2.lo );
		return Math.acos( Math.sin( point1_lat_in_radians ) * Math.sin( point2_lat_in_radians ) +
                Math.cos( point1_lat_in_radians ) * Math.cos( point2_lat_in_radians ) *
                Math.cos( point2_long_in_radians - point1_long_in_radians) ) * EARTH_RADIUS;
	}
}