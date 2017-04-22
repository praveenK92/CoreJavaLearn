package learn.ocp.core.chapter3;

public class MainLiterals {

	public static void main(String[] args) {
		float f1=(float)12354.12358;
		float f2=12354.12f;
		System.out.println("Float Test:\nf1="+f1+"\nf2="+f2);
		long l11=130l;
		byte b12=(byte)l11;
		byte b11=(byte)(12l);
		System.out.println("\nByte Test:\nb11="+b11+"\nb12="+b12);
	}

}
