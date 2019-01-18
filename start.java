package start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import storyline.StoryLine;

public class start {

	static Scanner playerInput;

	static boolean validResponse = false;

	public static void main(String[] args) throws InterruptedException {

		playerInput = new Scanner(System.in);

		System.out.println("<><><><><><><><><><><><><><><><><><><>");
		System.out.println("<>                                  <>");
		System.out.println("<>        Welcome to Confusion      <>");
		System.out.println("<>                                  <>");
		System.out.println("<>                                  <>");
		System.out.println("<>               Play               <>");
		System.out.println("<>                                  <>");
		System.out.println("<>               Exit               <>");
		System.out.println("<>                                  <>");
		System.out.println("<><><><><><><><><><><><><><><><><><><>");

		String playRequest = new String();

		validResponse = false;
		while (validResponse == false) {

			playRequest = playerInput.nextLine();

			// Initialize game start
			if (playRequest.equalsIgnoreCase("Play")) {
				validResponse = true;
				StoryLine.main(args);
			}
			// Exit the game
			else if (playRequest.equalsIgnoreCase("Exit")) {
				validResponse = true;
				System.out.print("Logging off");
				TimeUnit.SECONDS.sleep(1);
				for (int i = 0; i < 3; i++) {
					System.out.print(".");
					TimeUnit.SECONDS.sleep(1);
				}
				System.exit(0);
			}
			// Backup Case
			else {
				System.out.println("Not a valid response.");
			}
		}
	}
}
