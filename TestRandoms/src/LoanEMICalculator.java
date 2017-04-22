
public class LoanEMICalculator {
	
	public static void main(String[] args){
		System.out.println("EMI ="+
				(double)Math.round(calculate(64_00_000, 8.5, 20)*100.0)/100);
	}
	
	public static double calculate(int principal,double ratePerYear,int years){
		double ratePerMonth=ratePerYear/1200;
		int installments=years*12;
		double x=Math.pow(1+ratePerMonth, installments);
		double emi=(principal*ratePerMonth*x)/(x-1);
		return emi;
	}

}
