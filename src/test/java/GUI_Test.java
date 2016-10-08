package test.java;
import static org.junit.Assert.*;

import org.junit.Test;

import main.java.GUI;

public class GUI_Test {

	@Test
	public void testAdd() {
		GUI gui = new GUI();
		double result = gui.addition(1, 6);
		assertEquals(7,result, 0);
	}

}
