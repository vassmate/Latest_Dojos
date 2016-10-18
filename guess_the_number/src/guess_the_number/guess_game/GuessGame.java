package guess_the_number.guess_game;

import java.util.Scanner;

public class GuessGame {

	private int generatedRandom;
	private String userGuess;
	private boolean isInvalidInput = false;
	private int tries = 0;
	private int wins = 0;
	private int loses = 0;

	public GuessGame() {
		welcomeMsg();
		this.generatedRandom = generateRandomNumber();
		runGame();
	}

	public int getGeneratedRandom() {
		return generatedRandom;
	}

	public String getUserGuess() {
		return userGuess;
	}

	private int generateRandomNumber() {
		this.generatedRandom = (int) (Math.random() * 10);
		return getGeneratedRandom();
	}

	private String getUserInput() {
		@SuppressWarnings("resource")
		Scanner inScan = new Scanner(System.in);
		System.out.print(">");
		String inFromConsole = inScan.nextLine();
		this.userGuess = inFromConsole;
		return inFromConsole;
	}

	private int parseInput(String input) {
		int numberFromUser = Integer.parseInt(input);
		return numberFromUser;
	}

	private boolean checkUserInput() {
		String input = getUserGuess();
		if (input != null) {
			try {
				int guess = parseInput(input);
				if (guess == getGeneratedRandom()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				this.isInvalidInput = true;
				return false;
			}
		} else {
			return false;
		}
	}

	private void printResult(boolean result) {
		if (!isInvalidInput) {
			this.tries++;
			if (result) {
				System.out.println("You Win!");
				this.wins++;
			} else {
				System.out.println("You Lose!");
				this.loses++;
			}
			System.out.println("W/L=" + wins + "/" + loses + " Tries=" + tries);
		} else {
			System.out.println("Invalid input!");
			System.out.println("Enter only numbers!");
			isInvalidInput = false;
		}
	}

	private boolean doExit() {
		if (getUserGuess().equals("y") || getUserGuess().equals("Y")) {
			return true;
		}
		return false;
	}

	private void welcomeMsg() {
		System.out.println("Welcome to the number guessing game!");
		System.out.println("Guess a number below:");
	}

	private void runGame() {
		getUserInput();
		boolean result = checkUserInput();
		printResult(result);
		while (!doExit()) {
			System.out.println("\nDo you want to exit? (Y/N)");
			getUserInput();
			if (doExit()) {
				System.out.println("Bye!");
				break;
			} else {
				System.out.println("Than guess a number:");
				generateRandomNumber();
				getUserInput();
				result = checkUserInput();
				printResult(result);
			}
		}
	}
}
