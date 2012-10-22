
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Class takes input from user and Asker.class to build a highscore and compare the values*/

public class Highscore implements Comparable<Object> {
	private static ArrayList<Highscore> hlisten = new ArrayList<Highscore>();
		private Integer time;
		private Integer score;
		private String name; 
		private static File list = new File("list.txt");
		private static PrintWriter mywrite;
		public Highscore(String name, Integer time, Integer score) {
			this.score = score;
			this.time = time;
			this.name = name;
		}
		public Integer getScore() {
			return score;
		}
		public Integer getTime() {
			return time;	
		}
		public String getName() {
			return name;			
		}
		
		//Compares scores, if score is equal to other score it compares time
		public int compareTo(Object obj) {
			int result = getScore().compareTo(((Highscore)obj).getScore());
			if (result!=0) return result;
	        return this.getTime().compareTo(((Highscore) obj).getTime());
		}
		
		//Builds string of parameters
		public String toString() {  
			StringBuffer sb = new StringBuffer();
			sb.append(getName());
			sb.append("\t ");
			sb.append(getTime());
			sb.append("\t ");
			sb.append(getScore());
			sb.append("\t");
			return sb.toString();
		}
			public void main() throws IOException {
				makelist();
				
			}
			
			//Add parameters and builds the Highscore(hlisten) ArrayList
			public static void makelist() throws IOException { 
				mywrite = new PrintWriter(new FileWriter(list));
				Scanner input = new Scanner(System.in);
				String namer = input.next();
				hlisten.add(new Highscore(namer,Asker.finaltime,Asker.guesses));
		        Collections.sort(hlisten);
		        mywrite.println(hlisten);
		        System.out.println("");
		        System.out.println("\t-Highcore-");
				System.out.println("Name\t" +"Time\t" +"Guess #\t");
		        for (int i = 0; i < hlisten.size(); i++) {
		            System.out.println(hlisten.get(i).toString());
		            
		       
		        }
		      mywrite.close();
		      System.out.println("\n");
		      Asker.quit();
			}
			}
			
