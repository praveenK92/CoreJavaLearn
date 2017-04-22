package learn.ocp.core.hi;

public class LICInterestPercentage {
	static float prem,ans;
	static int n;
	public static void main(String[] args) {
		float x=(float)0.01,a=0,d=1_000;
		prem=76_313;
		ans=16_20_000;
		n=15;
		
		x=val(ans,x);
		
		while(a-ans>=d || a-ans<=-d){
			x+=0.0001;
			a=total(x);
		}
		float paid=(float)(prem*(0.03625+0.018125)+prem*n);
		
		System.out.print("Paid: "+paid+"\nTotal Received: "+a+"\nDifference: "+(ans-paid)+
		"\nPercentage:"+x*100);
	}
	static float total(float x){
		float ans=0;
		for(int i=1;i<=n;i++){
			ans=(ans+prem)*(1+x);
		}
		return ans;
	}
	static float val(float ans,float x){
		float a=0;
		while(a<=ans){
			x+=0.01;
			a=total(x);
		}
		return (float)(x-0.01);
	}
}