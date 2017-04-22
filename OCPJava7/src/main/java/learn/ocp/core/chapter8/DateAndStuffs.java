package learn.ocp.core.chapter8;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateAndStuffs {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		Calendar c1=Calendar.getInstance();
		if(Calendar.SUNDAY==c1.getFirstDayOfWeek()){
			System.out.println(c1.get(Calendar.DAY_OF_WEEK));
		}
		c1.add(Calendar.MONTH, 1);
		c1.roll(Calendar.MONTH, 13);
		Calendar c2=Calendar.getInstance();
		int y=c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR)+1;
		System.out.println(c1.getTime()+"\nYears="+y);
		
		DateFormat();
		locale();
		NumberFormatStuff();
	}
	public static void DateFormat(){
		DateFormat df[]=new DateFormat[7];
		df[0]=DateFormat.getInstance();
		df[1]=DateFormat.getDateInstance();
		df[2]=DateFormat.getDateInstance(DateFormat.SHORT);
		df[3]=DateFormat.getDateInstance(DateFormat.MEDIUM);
		df[4]=DateFormat.getDateInstance(DateFormat.LONG);
		df[5]=DateFormat.getDateInstance(DateFormat.FULL);
		df[6]=DateFormat.getDateInstance(DateFormat.DATE_FIELD);
		Date d=new Date();
		for(int i=0;i<7;i++){
			System.out.println(i+" Format:: "+df[i].format(d));
		}
		String s=df[2].format(d);
		try {
			d=df[2].parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void locale(){
		System.out.println("LOCALE TIME BRO!!!");
		Locale l1=new Locale("it");
		Locale l2=new Locale("hi","IN");
		Locale l3=new Locale("ja");
		
		DateFormat df[]=new DateFormat[7];
		df[0]=DateFormat.getInstance();
		df[1]=DateFormat.getDateInstance();
		df[2]=DateFormat.getDateInstance(DateFormat.SHORT,l1);
		df[3]=DateFormat.getDateInstance(DateFormat.FULL,l1);
		df[4]=DateFormat.getDateInstance(DateFormat.SHORT,l3);
		df[5]=DateFormat.getDateInstance(DateFormat.FULL,l2);
		df[6]=DateFormat.getDateInstance(DateFormat.DATE_FIELD);
		Date d=new Date();
		for(int i=0;i<7;i++){
			System.out.println(i+" Format:: "+df[i].format(d));
		}
		System.out.println(l2.getDisplayCountry()+" "+l2.getDisplayLanguage());
		
		Locale br=new Locale("pt","BR");
		Locale dk=new Locale("da","DK");
		Locale it=new Locale("it","IT");
		
		System.out.println(br.getDisplayCountry(br));		
	}
	public static void NumberFormatStuff(){
		Locale l2=new Locale("hi","IN");
		Locale br=new Locale("pt","BR");
		
		int a=1332;float f=12485.545895f;
		String s="Praveen";
		
		NumberFormat nfa[]=new NumberFormat[4];
		nfa[0]=NumberFormat.getInstance();
		nfa[1]=NumberFormat.getInstance(l2);
		nfa[2]=NumberFormat.getCurrencyInstance();
		nfa[3]=NumberFormat.getCurrencyInstance(l2);
		
		for(NumberFormat nf:nfa){
			System.out.println(nf.getCurrency()+" a= "+nf.format(a)+" f="+nf.format(f));
		}
		nfa[0].setMaximumFractionDigits(6);
		System.out.println(nfa[0].format(f));
		nfa[0].setParseIntegerOnly(true);
		
		try {
			System.out.println(nfa[0].parse("21121.54454"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
