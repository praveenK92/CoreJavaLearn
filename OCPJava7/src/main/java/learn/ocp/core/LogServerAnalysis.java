package learn.ocp.core;

import java.io.*;

public class LogServerAnalysis {
	private static String endLine="***************###############***************";
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while(line.equals(endLine)){
        	System.out.println(line);
        	line=br.readLine();
        }
        //br.close();
    }

}
