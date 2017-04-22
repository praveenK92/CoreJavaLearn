package learn.ocp.core.hi;

public class LICBimaBachat {
	static float prem,ans;
	static int n;
	public static void main(String[] args) {
		float x=(float)0.01,a=0,d=100;
		prem=54_313;
		ans=86_740;
		n=9;
		
		//x=val(ans,x);
		x=0.03f;
		while(a-ans>=d || a-ans<=-d){
			x+=0.0001;
			a=total(x);
		}
		float paid=(float)(prem*0.03625+prem);
		
		System.out.print("Paid: "+paid+"\nTotal Received: "+a+"\nDifference: "+(ans-paid)+
		"\nPercentage:"+x*100);
	}
	static float total(float x){
		float ans1=prem;
		for(int i=1;i<=n;i++){
			if(n==3 || n== 6){
				ans1-=11250;
				ans-=11250;
			}
			ans1=(ans1)*(1+x);
		}
		return ans1;
	}
	/*static float val(float ans,float x){
		float a=0;
		while(a<=ans){
			x+=0.01;
			a=total(x);
		}
		return (float)(x-0.01);
	}*/
}