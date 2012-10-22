import java.io.IOException;

//** Added this comment

public class Game {
	
	/*Game class initializes the game*/
	
	public static void main(String[] args) throws IOException {
		start();
	}
	
	//Prints welcome message and initializes startthegame method from Asker
	private static void start() throws IOException {
		System.out.println("Welcome to the guessing game \n"); 
		Asker.startthegame();													
	}

}
