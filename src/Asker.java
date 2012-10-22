import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.lang.NumberFormatException;

public class Asker {
	
	static Random rand = new Random();
	
	private static int winnumb = rand.nextInt(1001-1);  
	public static Integer guesses = 1;
	private static int g = 0; // Number that player guesses
	private static long starttime;
	private static long endtime;
	public static int time = 0;
	public static Integer finaltime = 0;
	

	static NumberFormatException exc = new NumberFormatException();
	static Scanner textinput = new Scanner(System.in);
	static Scanner answer = new Scanner(System.in);
	
	
	//Method to initialize the game sequence
	public static void startthegame() throws IOException{
		winnumb = rand.nextInt(1001-1);
		guesses = 1;
		System.out.println("Please guess a number between 1-1000 "+winnumb);
		starttime = System.nanoTime();
		inputguess();
		
	}
	
	 //Input guessing value as String, sends string to errorcheck for checking input is correct
	private static void inputguess() throws IOException {
		String input = textinput.next();
		if ("quit".equals(input)) {
			quit();
		}
		else if ("highscore".equals(input)){
			BufferedReader in = new BufferedReader(new FileReader("list.txt"));
			String line = in.readLine();
			while(line != null)
			{
			  System.out.println(line+"\n");
			  line = in.readLine();
			}
			in.close();
			inputguess();
		}
		
		else if (errorcheck(input) ==true || g > 1000 || g < 0) {
			System.out.println("404 ERROR, that is invalid input, please try again \n");
			inputguess();
		}
		else {
			g= Integer.parseInt(input);
			guessing(g);
		}
		}
	
	//Parse the String input from inputguess to Int if possible, else response with error (if true == error, false == correct)
	private static boolean errorcheck(String h){
		try
		{
			g= Integer.parseInt(h);
		}
		catch(NumberFormatException nfe) 
		{
			return true;
			
		}
			return false;	
			
		}
		

	
	//Calculates whether the guess is too low or too high or correct and responds appropriately
	private static void guessing(int guess) throws IOException {   
		if (guess < winnumb) {
			System.out.println("Higher, try again! ");
			guesses++;
			inputguess();
		}
		else if (guess > winnumb) {
			System.out.println("Lower, try again! ");
			guesses++;
			inputguess();
		}
						
		else {
			endtime = System.nanoTime();
			finaltime = times(starttime, endtime);
			System.out.println("\nCongratulations! You guessed the right number wich was " +winnumb +" in " +guesses +" guesses and " +" \n" +finaltime+" seconds.");
			System.out.println("\nType in your name for the highscore");
			Highscore.makelist();
			
			}
		}

		//Calculates game time
		private static Integer times(long starttime, long endtime) {
		long p = endtime - starttime;
		long r = p / 1000000000;
		int e = (int) r;
		return e;
		}
		
		//Method called to print quit dialog box and restart or end program
		public static void quit() throws IOException{
			System.out.println("Play again? yes or no");
			String answer1 = answer.next();
			if ("yes".equals(answer1)){
				startthegame();
			}
				
				else if ("no".equals(answer1)){
					System.out.println("Byebye!");
		}
				else{
					System.out.println("ERROR! You need to type yes or no\n");
					quit();
				}
		}	
		
	}
	


