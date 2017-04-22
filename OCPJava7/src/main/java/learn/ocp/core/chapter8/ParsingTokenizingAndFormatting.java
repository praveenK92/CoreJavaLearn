package learn.ocp.core.chapter8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingTokenizingAndFormatting {

	public static void main(String[] args) {
		Regx();
	}
	public static void Regx(){
		PatternMatchStuff("aba","ababababab");
		PatternMatchStuff("\\d", "a1b2c3d4e5f6g7h8");
		PatternMatchStuff("\\s", "a1 b2 c3d4 e5f6 g7h8");
		PatternMatchStuff("\\b", "aa bdf %$#cdfg8d");
		PatternMatchStuff("[abc]", "abd sd ab c");
		PatternMatchStuff("[a-z]", "aBd sd ab c");
		PatternMatchStuff("[a-cA-C]", "anasd b f A NSakjHHLJKL C");
		PatternMatchStuff("0[xX][0-9A-Fa-f]", "0x 0x5 0Xa 0xg");
		
		PatternMatchStuffGroup("\\d+", "0 1^5 s475 & 5^&87");
		PatternMatchStuffGroup("0[xX]([0-9A-Fa-f])+", "0x 0x5f 0Xfe 0xg 0x12fgd");
		PatternMatchStuffGroup("pj([^,])+", "pj123.pdf,pjasd.txt,adas.txt,dass.pdf,pj1.pdf");
		PatternMatchStuffGroup(".*xx", "yyxxxyxx");
		PatternMatchStuffGroup(".?xx", "yyxxxyxx");
	}
	public static void PatternMatchStuff(String pattern,String text){
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(text);
		System.out.println("Given Text matches for:");
		while(m.find()){
			System.out.print(m.start()+" ");
		}
		System.out.println("");
	}
	
	public static void PatternMatchStuffGroup(String pattern,String text){
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(text);
		System.out.println("Given Text matches for:");
		while(m.find()){
			System.out.print(m.start()+"-"+m.group()+",");
		}
		System.out.println("");
	}

}
