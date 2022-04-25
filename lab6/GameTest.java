package wk6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testUserWon() {
		assertTrue(Game.userWon("Pershult", "Klyket"));
		assertTrue(Game.userWon("Pershult", "Skadis"));
		assertFalse(Game.userWon("Pershult", "Pershult"));
		assertFalse(Game.userWon("Pershult", "Tjusig"));
		assertFalse(Game.userWon("Pershult", "Hovolm"));
		assertTrue(Game.userWon("Klyket", "Tjusig"));
		assertTrue(Game.userWon("Klyket", "Hovolm"));
		assertFalse(Game.userWon("Klyket", "Klyket"));
		assertFalse(Game.userWon("Klyket", "Skadis"));
		assertFalse(Game.userWon("Klyket", "Pershult"));
		assertTrue(Game.userWon("Tjusig", "Pershult"));
		assertTrue(Game.userWon("Tjusig", "Skadis"));
		assertFalse(Game.userWon("Tjusig", "Tjusig"));
		assertFalse(Game.userWon("Tjusig", "Hovolm"));
		assertFalse(Game.userWon("Tjusig", "Klyket"));
		assertTrue(Game.userWon("Skadis", "Hovolm"));
		assertTrue(Game.userWon("Skadis", "Klyket"));
		assertFalse(Game.userWon("Skadis", "Skadis"));
		assertFalse(Game.userWon("Skadis", "Tjusig"));
		assertFalse(Game.userWon("Skadis", "Pershult"));
		assertTrue(Game.userWon("Hovolm", "Pershult"));
		assertTrue(Game.userWon("Hovolm", "Tjusig"));
		assertFalse(Game.userWon("Hovolm", "Hovolm"));
		assertFalse(Game.userWon("Hovolm", "Skadis"));
		assertFalse(Game.userWon("Hovolm", "Klyket"));
	}

}
