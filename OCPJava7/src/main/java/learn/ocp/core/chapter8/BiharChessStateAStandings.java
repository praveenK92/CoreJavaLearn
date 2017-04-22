package learn.ocp.core.chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiharChessStateAStandings {
	public static int x=0;

	public static void main(String[] args) {
		ArrayList<Player> plList=new ArrayList<Player>();
		HashMap<String, Player> ran=new HashMap<String, Player>();
		
		try(BufferedReader r=new BufferedReader(new FileReader(new File
				("./src/main/resources/biharStateA.txt")))){
			
			String l="";
			
			while(l!=null){
				l=r.readLine();
				//System.out.println(l);
				if(l==null)break;
				if(l.contains("Round") || l.equals(""))continue;
				
				String s1=PatternMatchForPlayer("\\d\\..([a-zA-Z])+(\\s([a-zA-Z])+)?(\\s([a-zA-Z])+)?", l);
				s1=s1.substring(2).trim();
				
				String res=PatternMatchForPlayer("[0-1]-[0-1]", l);
				
				String s2=PatternMatchForPlayer("\\d\\s([a-zA-Z])+(\\s([a-zA-Z])+)?(\\s([a-zA-Z])+)?", l);
				s2=s2.substring(2).trim();
				
				Player pl1=ran.get(s1);
				if(pl1==null){
					Player pl=new Player(s1);
					pl1=pl;
					ran.put(s1,pl);
					plList.add(pl);
				}
				
				Player pl2=ran.get(s2);
				if(pl2==null){
					Player pl=new Player(s2);
					pl2=pl;
					ran.put(s2,pl);
					plList.add(pl);
				}
				
				float p1=0,p2=0;
				if(res.equals("1-0")){
					p1=1;
					pl1.addOpponent(pl2, 1);
					pl2.addOpponent(pl1, -1);
				}else if(res.equals("0-1")){
					p2=1;
					pl1.addOpponent(pl2, -1);
					pl2.addOpponent(pl1, 1);
				}else{
					p1=0.5f;
					p2=0.5f;
					pl1.addOpponent(pl2, 0);
					pl2.addOpponent(pl1, 0);
				}
				
				pl1.incrScore(p1);
				pl2.incrScore(p2);
				
				/*if(pl1.getName().equals("Rahul Kumar")){
					System.out.println(l+" "+pl1.getScore());
				}else if(pl2.getName().equals("Rahul Kumar")){
					System.out.println(l+" "+pl2.getScore());
				}*/
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Collections.sort(plList);
		System.out.println("Standings Up Till Now::");
		int i=1;
		Iterator<Player> ii=plList.iterator();
		while(ii.hasNext()){
			Player p=ii.next();
			System.out.println("Player No: "+i+". "+p);
			//System.out.println(p.getOpponents());
			i++;
		}
	}
	
	public static String PatternMatchForPlayer(String pattern,String text){
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(text);
		if(m.find()){
			x=m.start();
			return m.group();
		}
		else return "";
	}
}

class Player implements Comparator<Player>,Comparable<Player>{
	private String name;
	private float score;
	private Map<String,Integer> opponents=new LinkedHashMap<String,Integer>();
	
	Player(){
		name="";score=0;
		opponents=new HashMap<String,Integer>();
	}
	Player(String s){
		name=s;score=0;
		opponents=new HashMap<String,Integer>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public void incrScore(float f){
		score+=f;
	}
	public Map<String,Integer> getOpponents() {
		return opponents;
	}
	public void setOpponents(Map<String,Integer> opponents) {
		this.opponents = opponents;
	}
	
	void addOpponent(Player opp,int res){
		opponents.put(opp.getName(),res);
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", score=" + score;
	}

	@Override
	public int compare(Player p1, Player p2) {
		if(p1.getScore()>p2.getScore())return 1;
		else if(p1.getScore()==p2.getScore()){
			return p1.getName().compareTo(p2.getName());
		}
		else return -1;
	}
	
	//this one is used for comparison with Collections class.
	@Override
	public int compareTo(Player o) {
		if(this.score>o.getScore())return -1;
		else if(this.score==o.getScore()){
			Integer p11=opponents.get(o.getName());
			if(p11==null)return 0;
			
			switch(p11){
			case 1:return -1;
			case -1:return 1;
			default:return this.getName().compareTo(o.getName());
			}
		}
		else return 1;
	}
	
}