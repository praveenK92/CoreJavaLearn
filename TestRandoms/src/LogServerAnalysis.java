import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class LogServerAnalysis {
	private static String endLine="***************###############***************";
	private static String line;
	private static BufferedReader br; 
	
	public static void main(String args[] ) throws Exception {
		LinkedHashMap<String, Integer> paramCount=new LinkedHashMap<>();
		
        br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        
        while(!line.equals(endLine)){
        	
        	if(line.contains("Started GET")){
        		if(line.contains("?")){
        			line=line.substring(line.indexOf("?")+1);
                    line=line.substring(0,line.indexOf("\""));
            		String paramList[]=line.split("&");
            		for(String s:paramList){
            			//System.out.println(s);
            			s=s.substring(0,s.indexOf("="));
            			if(paramCount.containsKey(s)){
            				paramCount.put(s, paramCount.get(s)+1);
            			}else{
            				paramCount.put(s,1);
            			}
            		}        			
        		}
        	}
        	
        	line=br.readLine();
        }
		line=br.readLine();
		line=br.readLine();
		
		if(line.contains("?")){
			line=line.substring(line.indexOf("?")+1);
    		String paramList[]=line.split("&");
    		
    		for(int i=0;i<5;i++){
    			String s=paramList[i];
    			s=s.substring(0,s.indexOf("="));
    			if(paramCount.containsKey(s)){
    				System.out.println(paramCount.get(s));
    			}
    		}
		}
		
        br.close();
    }
}
