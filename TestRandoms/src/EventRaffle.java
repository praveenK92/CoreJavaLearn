import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EventRaffle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String, HashSet<Integer>> hm=new HashMap<>();
		
		int n=sc.nextInt();
		Person p[]=new Person[n];
		for(int i=0;i<n;i++){
			p[i]=new Person();
			p[i].id=sc.nextInt()-1;
			int m=sc.nextInt();
			for(int j=0;j<m;j++){
				String x=sc.next();
				HashSet<Integer> ll=hm.get(x);
				if(ll==null){
					HashSet<Integer> ll1=new HashSet<>();
					ll1.add(i);
					hm.put(x, ll1);
				}else{
					ll.add(i);
					hm.put(x, ll);
				}
				
				p[i].ll.add(x);
			}
		}
		Event ee[]=new Event[n];
		for(int i=0;i<n;i++){
			ee[i]=new Event();
			int m=sc.nextInt();
			for(int j=0;j<m;j++){
				String x=sc.next();
				ee[i].ee.add(x);
				HashSet<Integer> h1=hm.get(x);
				Iterator<Integer> ii=h1.iterator();
				while(ii.hasNext()){
					ee[i].pep.add(ii.next());
				}
				//ee[i].pep.addAll(h1);
			}
		}
		
		int ans=0;
		for(int i=0;i<n;i++){
			
			for(int j=0;j<n;j++){
				if(p[i].isHappy(ee[j].ee)){
					p[i].likes.add(j);
				}
			}
			
			if(p[i].isHappy(ee[p[i].id].ee)){
				p[i].hap=true;
				ans++;
			}
		}
		
		for(int i=0;i<n;i++){
			HashSet<Integer> hh=ee[i].pep;
			Iterator<Integer> ii=hh.iterator();
			while(ii.hasNext()){
				int a=ii.next(),b;
				b=p[a].id;
				HashSet<Integer> hh1=ee[b].pep;
				Iterator<Integer> ii1=hh1.iterator();
				while(ii1.hasNext()){
					int a1=ii1.next(),b1;
					b1=p[a1].id;
					if(p[a1].hap && p[a].hap) continue;
					else if(!p[a1].hap && p[a].hap){
						if(p[a1].likes.contains(b) && p[a].likes.contains(b1)){
							ans++;
							p[a1].id=b;p[a].id=b1;
							p[a1].hap=true;p[a].hap=true;
						}
					}
					else if(p[a1].hap && !p[a].hap){
						if(p[a1].likes.contains(b) && p[a].likes.contains(b1)){
							ans++;
							p[a1].id=b;p[a].id=b1;
							p[a1].hap=true;p[a].hap=true;
						}
					}
					else{
						if(p[a1].likes.contains(b) && p[a].likes.contains(b1)){
							ans+=2;
							p[a1].id=b;p[a].id=b1;
							p[a1].hap=true;p[a].hap=true;
						}
						else if(p[a1].likes.contains(b)){
							ans++;
							p[a1].id=b;p[a].id=b1;
							p[a1].hap=true;p[a].hap=false;
						}
						else if(p[a].likes.contains(b1)){
							ans++;
							p[a1].id=b;p[a].id=b1;
							p[a1].hap=false;p[a].hap=true;
						}else continue;
					}
				}
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}
class Person{
	int id;
	List<String> ll=new ArrayList<>();
	boolean hap=false;
	HashSet<Integer> likes=new HashSet<>();
	
	boolean isHappy(List<String> a){
		for(int i=0;i<ll.size();i++){
			if(a.contains(ll.get(i)))return true;
		}
		return false;
	}
}
class Event{
	int id=-1;
	List<String> ee=new ArrayList<>();
	HashSet<Integer> pep=new HashSet<>();
}