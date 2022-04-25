package wk6;

import java.util.Random;
import java.util.Scanner;

/*
 * Daniel Mogil
 * 02/21/22
 * Assignment 6. A Game
 *
 * Simulates a user vs. computer game of Uppföra
 */

public class Game {

	private static void printRules() {
		System.out.println(
				"Rules:\nPershult beats Klyket, Skadis\nKlyket beats Tjusig, Hovolm\nTjusig beats Pershult, Skadis\nSkadis Beats Hovolm, Klyket\nHovolm beats Pershult, Tjusig\nThe computer wins in the event of a tie.");
	}

	private static char promptNewRound(Scanner sc) {
		String newRound = sc.next();
		while (!newRound.equals("y") && !newRound.equals("n")) {
			System.out.print("Response must be 'y' or 'n': ");
			newRound = sc.next();
		}
		return newRound.charAt(0);
	}

	public static int getUserMove(Scanner sc) {
		System.out.print(
				"Select a move:\nSkadis (0)\nTjusig (1)\nKlyket (2)\nHovolm(3)\nPershult(4) ");
		int userMove = sc.nextInt();
		while (userMove < 0 || userMove > 4) {
			System.out.print("Select a valid move identifier (0-4): ");
			userMove = sc.nextInt();
		}
		System.out.println();
		return userMove;
	}

	public static int getComputerMove(Random rd) {
		return rd.nextInt(5);
	}

	public static boolean userWon(String userMove, String computerMove) {
		switch (userMove) {
			case "Pershult" :
				return computerMove.equals("Klyket")
						|| computerMove.equals("Skadis") ? true : false;
			case "Klyket" :
				return computerMove.equals("Tjusig")
						|| computerMove.equals("Hovolm") ? true : false;
			case "Tjusig" :
				return computerMove.equals("Pershult")
						|| computerMove.equals("Skadis") ? true : false;
			case "Skadis" :
				return computerMove.equals("Hovolm")
						|| computerMove.equals("Klyket") ? true : false;
			case "Hovolm" :
				return computerMove.equals("Pershult")
						|| computerMove.equals("Tjusig") ? true : false;
			default :
				return false;
		}
	}

	private static void printGameResults(int roundsPlayed, int userWins) {
		System.out.println("\u001B[32m" // green
				+ String.format(
						"Rounds played: %d\nUser's wins: %d\nComputer's wins: %s",
						roundsPlayed, userWins, roundsPlayed - userWins));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] moves = new String[]{"Skadis", "Tjusig", "Klyket", "Hovolm",
				"Pershult"};
		int roundsPlayed = 0;
		int userWins = 0;

		printRules();
		System.out.print("New round? (y/n) ");

		char newRound = promptNewRound(sc);

		while (newRound == 'y') {
			String userMove = moves[getUserMove(sc)];
			String computerMove = moves[getComputerMove(rd)];
			boolean isUserWinner = userWon(userMove, computerMove);
			roundsPlayed++;
			if (isUserWinner)
				userWins++;
			System.out.println(String.format(
					"User's move: %s\nComputer's move: %s\nRound winner: %s\n",
					userMove, computerMove,
					isUserWinner ? "User" : "Computer"));

			System.out.print("New round? (y/n) ");
			newRound = promptNewRound(sc);
		}
		printGameResults(roundsPlayed, userWins);
	}
}
