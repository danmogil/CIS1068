import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SouthieTest {

	@Test
	void testAlterLine() {
		assertEquals("i left my cah keys by the hahboh.",
				Southie.alterLine("I left my car keys by the harbor."));
		assertEquals("tunar ", Southie.alterLine("Tuna "));
		assertEquals("cubar ", Southie.alterLine("Cuba "));
		assertEquals("idear ", Southie.alterLine("Idea "));
		assertEquals("a ", Southie.alterLine("A "));
		assertEquals("a tunar ", Southie.alterLine("A tuna "));
		assertEquals("wicked hahd ", Southie.alterLine("very hard "));
		assertEquals("deeyah ", Southie.alterLine("Deer "));
		assertEquals("veneehs ", Southie.alterLine("veneers "));
		assertEquals("doowah ", Southie.alterLine("door "));
	}

}
