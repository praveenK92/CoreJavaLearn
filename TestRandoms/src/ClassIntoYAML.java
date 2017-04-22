import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ClassIntoYAML {
	private static String line;
	private static BufferedReader br;
	
	public static void main(String args[] ) throws Exception {
		LinkedHashMap<String, Integer> paramCount=new LinkedHashMap<>();
		
        br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        while(line!=null){
        	if(line.contains("@class")){
        		Classes c=new Classes();
        		
        		        		
        	}
        	line=br.readLine();
        }
        
    }
	static Classes makeClass(String s){
		Classes c=new Classes();
		
		return c;
	}
}
class Classes{
	String author;
	String class1;
	String desc;
	List<Method> methods=new ArrayList<>();
	List<Property> proprties;
	List<Classes> subclasses=new ArrayList<>();
	String super1;
}
class Property{
	String desc;
	String type;
	String var;
}
class Method{
	String desc;
	String method;
	List<Property> params=new ArrayList<>();
	String return1;
	String virtual;
}
