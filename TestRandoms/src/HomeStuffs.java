import java.text.DecimalFormat;

public class HomeStuffs {

	public static void main(String[] args){
		int totalCost=0;
		int monthlyCost=20_000,n=2,year=2017;
		int yearlyCost=monthlyCost*12;
		
		DecimalFormat df = new DecimalFormat();
		df.applyLocalizedPattern("#,###");
		System.out.println("Starting with MonthlyyCost for year "+year +
				":"+df.format(monthlyCost));
		for(int i=0;i<n;i++){
			System.out.println("YearlyCost for year "+year++ +
					" is:"+df.format(yearlyCost));
			totalCost+=yearlyCost;
			//10% increment
			yearlyCost*=1.1;
		}
		System.out.println("TotalCost in "+n+" years: "+df.format(totalCost));

	}

}
