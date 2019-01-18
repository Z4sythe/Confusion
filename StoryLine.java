package storyline;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import player.Player;

public class StoryLine {

	static Scanner playerInput;
	static Random choiceGenerator = new Random();

	static int choice = 0;
	static String playerContinue;
	static int playerSelection;

	public static void main(String[] args) throws InterruptedException {

		// Scanner Setup
		playerInput = new Scanner(System.in);

		// Intro
		System.out.println("\n\nWelcome to 'Confusion'");
		System.out.println(
				"This is a simulation of a more realistic "
				+ "version of the game of life, "
				+ "set on the college campus of your choice.");
		Player player = new Player(50);
		System.out.println(
				"What is your name? "
				+ "\nUse the space below for your reponse, then press enter.");
		player.setName(playerInput.nextLine());
		System.out.println(
				"What is your chosen university? "
				+ "\nAgain, press enter after entering your response.");
		player.setUniversity(playerInput.nextLine());

		System.out.println(
				"Hit enter to begin your journey. If not, turn back now for "
				+ "there is no return \n(You can enter 0 to log off at any point).");
		playerContinue = playerInput.nextLine();
		//

		// Story Start
		System.out.println("\nYou are " + player.getName()
				+ ", a college student at " + player.getUniversity() + ".");
		System.out.println("\nYou are currently at " + player.getSanity()
				+ " sanity. If this reaches zero, the game will end.");
		System.out.println("\nIt is 7 AM. " + player.getName()
				+ "'s alarm buzzes annoyingly. Does " + player.getName() + ":");
		System.out.println("\n1) Get out of bed \n2) Stay in Bed");

		// The first choice works like it should...
		playerSelection = playerInput.nextInt();
		checkValidResponseAndExit(playerSelection);

		// Choice 1
		if (playerSelection == 1) {
			// Checks if the player's decision matched the computer's
			// random one deducts sanity if not.
			System.out.println(player.getName() + " gets out of bed.\n\nWould "
					+ player.getName() + " like to:");
			System.out.println(
					"\n1) Go to class \n2) Go to professor office hours");
			sanityAdjust(player);
			// ...but this is where the fun begins...
			playerSelection = playerInput.nextInt();
			checkValidResponseAndExit(playerSelection);
			choice = getRandom(2) + 1;
			// Choice 2
			if (choice == 1) {
				System.out.println(
						player.getName() + " makes it to class.\n\nWould "
								+ player.getName() + " like to:");
				System.out.println("\n1) Leave early \n2) Participate");
				sanityAdjust(player);
				playerSelection = playerInput.nextInt();
				checkValidResponseAndExit(playerSelection);
				choice = getRandom(2) + 1;
				// Choice 3a
				if (choice == 1) {
					System.out.println(player.getName()
							+ " falls into a pit of skipping "
							+ "classes after leaving this one early.");
					dockSanityLoop(player);
					gameEnd(player);
				}
				// 3a
				else if (choice == 2) {
					System.out.println(player.getName()
							+ " participates in class.\n\nWould "
							+ player.getName() + " like to:");
					System.out.println(
							"\n1) Ask the professor about research "
							+ "he/she is doing \n2) Go workout");
					sanityAdjust(player);
					playerSelection = playerInput.nextInt();
					checkValidResponseAndExit(playerSelection);
					choice = getRandom(2) + 1;
					// Choice 4a
					if (choice == 1) {
						System.out.println(player.getName()
								+ " asks their professor about research "
								+ "opportunities.\n\nWould "
								+ player.getName() + " like to:");
						System.out.println(
								"\n1) Start working in their lab "
								+ "\n2) Take some time to 'think about it'");
						sanityAdjust(player);
						playerSelection = playerInput.nextInt();
						checkValidResponseAndExit(playerSelection);
						choice = getRandom(2) + 1;
						// Choice 5a
						if (choice == 1) {
							System.out.println(
									"Congratulations for making it down the only path "
									+ "possible with sanity left. \nThanks for playing!");
							gameEnd(player);
						}
						// 5a
						else if (choice == 2) {
							System.out.println(player.getName()
									+ " decides to pass on the professor's offer and comes "
									+ "to regret it a few weeks later.");
							dockSanityLoop(player);
							gameEnd(player);
						}
					}
					// 4a
					else if (choice == 2) {
						System.out.println(player.getName()
								+ " goes to the gym to get swole, never to be seen again.");
						dockSanityLoop(player);
						gameEnd(player);
					}
				}
			}
			// 2
			else if (choice == 2) {
				System.out.println(player.getName()
						+ " makes it to professor office hours.\n\nWould "
						+ player.getName() + " like to:");
				System.out.println(
						"\n1) Ask about other students in the class. "
						+ "\n2) Ask questions about the course material.");
				sanityAdjust(player);
				playerSelection = playerInput.nextInt();
				checkValidResponseAndExit(playerSelection);
				choice = getRandom(2) + 1;
				// Choice 3b
				if (choice == 1) {
					System.out.println(player.getName()
							+ " asks about other students in the class.\n\nWould "
							+ player.getName() + " like to:");
					System.out.println(
							"\n1) Ask for an A. \n2) Ask questions "
							+ "about the course material.");
					playerSelection = playerInput.nextInt();
					checkValidResponseAndExit(playerSelection);
					System.out.println("Just kidding! " + player.getName()
							+ " thought they had a choice!");
					dockSanityLoop(player);
					gameEnd(player);
				}
				// 3b
				else if (choice == 2) {
					System.out.println(player.getName()
							+ " asks about the course material.\n\nWould "
							+ player.getName() + " like to:");
					System.out.println(
							"\n1) Ask for an A. \n2) Ask questions "
							+ "about the course material.");
					sanityAdjust(player);
					playerSelection = playerInput.nextInt();
					checkValidResponseAndExit(playerSelection);
					choice = getRandom(2) + 1;
					// Choice 4c
					if (choice == 1) {
						System.out.println("The audacity! A's are earned!");
						dockSanityLoop(player);
						gameEnd(player);
					}
					// 4c
					else if (choice == 2) {
						System.out.println(player.getName()
								+ " is told to Google their question...");
						dockSanityLoop(player);
						gameEnd(player);
					}
				}
			}
		}
		// 1
		else if (playerSelection == 2) {
			System.out.println(
					"You continue to put off getting out of "
					+ "bed and sleep through the whole day.");
			dockSanityLoop(player);
			gameEnd(player);
		}
	}

	// Returns a random value between 0 and the parameter number.
	public static int getRandom(int max) {
		return (int) (Math.random() * max);
	}

	public static void checkValidResponseAndExit(int response)
			throws InterruptedException {
		boolean valid = false;
		while (valid == false) {
			if (response == 1 || response == 2) {
				valid = true;
			} else if (response == 0) {
				valid = true;
				System.out.print("Logging off");
				TimeUnit.SECONDS.sleep(1);
				for (int i = 0; i < 3; i++) {
					System.out.print(".");
					TimeUnit.SECONDS.sleep(1);
				}
				System.exit(0);
			} else {
				System.out.println("Invalid Command");
				response = playerInput.nextInt();
				playerSelection = response;
			}
		}
	}

	public static void dockSanityLoop(Player player)
			throws InterruptedException {
		System.out.println("Sanity levels dropping fast:");
		while (player.getSanity() > 0) {
			player.setSanity(player.getSanity() - 5);
			if (player.getSanity() < 0) {
				player.setSanity(0);
			}
			System.out.println(player.getSanity());
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void sanityAdjust(Player player) throws InterruptedException {
		// Accounts for the first turn, and other any time the player and
		// computer aren't aligned.
		if (choice != 0 && choice != playerSelection) {
			player.setSanity(player.getSanity() - 5);
		}
		System.out.println("Sanity: " + player.getSanity());

		if (player.getSanity() <= 0) {
			gameEnd(player);
		}
	}

	// Standardized game ending scene to make it less redundant above.
	public static void gameEnd(Player player) throws InterruptedException {
		System.out.print("\nSimulation Complete");
		TimeUnit.SECONDS.sleep(1);
		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("\n" + player.getName() + " finished the game with "
				+ player.getSanity() + " sanity.");
		TimeUnit.SECONDS.sleep(3);
		System.out.print("\nLogging off");
		TimeUnit.SECONDS.sleep(1);
		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.exit(0);
	}
}
